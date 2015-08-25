/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pkg1_ex2a;

/**
 *
 * @author simon
 */

/* What happens is that since the Even.next() method is NOT atomic, part of the 
    increments can occur in both threads, whhich means that when one thread
    is done with its call to Even.next() another thread might be incrementing
    its value at the same time. This could result in various increments from 0 
    up till 4 before the next test is done! this causing uneven numbers.
*/

public class Threads1_ex2a {

    
    
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
