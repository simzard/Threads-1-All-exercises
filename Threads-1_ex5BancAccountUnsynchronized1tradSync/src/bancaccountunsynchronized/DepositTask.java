/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaccountunsynchronized;

/**
 *
 * @author jekm
 */
public class DepositTask implements Runnable
{
  BankAccountUnsynchronized acc;
  public DepositTask(BankAccountUnsynchronized a)
  {
    acc = a;
  }
  @Override
  public void run()
  {
    try
    {
      for (int i = 1 ; i< 30 ;i++ ) // after a little while deposit 29 * 100 
      {                             //  = 2900
        acc.deposit(100);
        Thread.sleep(1);
      }
    }
    catch (InterruptedException e) {}
  }
}

