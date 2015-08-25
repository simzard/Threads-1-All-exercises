/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pkg1_ex2b;

/**
 *
 * @author simon
 */

/* 
    Since I've added synchronized to the Even.next() method, the Even object 
    can never be used by more than one thread at the time, thus resulting
    in correctly returnning only even numbers. Other threads who want to invoke
    the Even.next() method must patiently wait untill the Even object is free
    (and it's lock is freed when the current thread's method call ends)
*/

public class Threads1_ex2b {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Even theObject = new Even();
        Thread t1 = new Thread(new EvenRunner(theObject, "Thread 1"));
        Thread t2 = new Thread(new EvenRunner(theObject, "Thread 2"));
        
        t1.start();
        t2.start();
        
    }
    
}
