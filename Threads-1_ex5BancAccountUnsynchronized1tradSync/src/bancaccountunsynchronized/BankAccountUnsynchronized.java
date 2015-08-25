package bancaccountunsynchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// NOT THREADSAFE
public class BankAccountUnsynchronized {

  private double balance;
  private Lock lock = new ReentrantLock();

  public BankAccountUnsynchronized() {
    balance = 0;
  }

  public synchronized void deposit(double amount) {
//    double newBalance = balance + amount;
//    balance = newBalance;  
    balance += amount;
   }

  public synchronized void withdraw(double amount) {
//    double newBalance = balance - amount;
//    balance = newBalance;
     balance -= amount;
   }

  public double getBalance() {
    return balance;
  }
}
