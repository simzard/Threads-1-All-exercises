package bancaccountunsynchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Identify where it goes wrong :
    It goes wrong in the BankAccountUnsynchronized class:
        in the withdraw() and deposit() methods. They are not 
        synchronized and thus will be victims to a race condition.

        What should the closing balance be?
            It should be 0, since we withdraw and deposit the same amount!
            
    Experiment: increasing the number of threads increse the imprecision
                   however - it seams that we get more OK values
                   but still that is totally random
*/

public class BankApp
{
  private static final int NUMBER_OF_DEPOSIT_AND_WITHDRAW_TASKS = 30;
  
  private static void executeTransactions(){
    BankAccountUnsynchronized acc = new BankAccountUnsynchronized();
    //=== start 3 hævetråde og 3 indsæt-tråde - alle deler samme konto
    List<Thread> threads = new ArrayList();
    for (int i=0; i< NUMBER_OF_DEPOSIT_AND_WITHDRAW_TASKS;i++ ) 
    {
      DepositTask dt  = new DepositTask(acc);
      WithdrawTask wt = new WithdrawTask(acc);
      threads.add(new Thread(dt));
      threads.add(new Thread(wt));
    }
    for(Thread thread: threads){
      thread.start();
    }
    
    for(Thread thread: threads){
      try {
        thread.join();
      } catch (InterruptedException ex) {
        Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    String result = acc.getBalance() == 0 ? "OK, " : "FAILED, ";
    System.out.print(result);
    System.out.println("Account value after all transactions: "+acc.getBalance());
    
  }
  
  public static void main(String[] args)
  {
    for(int i = 0; i < 10; i++){
      executeTransactions();
    }
  }
  
}
