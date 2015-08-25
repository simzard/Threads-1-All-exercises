/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pkg1_ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class Threads1_ex1 {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        Task3 t3o = new Task3();
        
        Thread task1 = new Thread(new Task1());
        Thread task2 = new Thread(new Task2());
        Thread task3 = new Thread(t3o);
        
        task1.start();
        task2.start();
        task3.start();
        
        try {
            Thread.sleep(10000);
            t3o.setAlive(false);
            System.out.println("Main thread: Thread 3 stopped!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Threads1_ex1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (task1.isAlive() || task2.isAlive()) 
            ;
                
        
    }
    
}
