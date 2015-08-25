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
public class Task3 implements Runnable {

    private boolean alive = true;
    
    public void setAlive(boolean a) {
        alive = a;
    }
    
    @Override
    public void run() {
        int i = 10;
        while(alive) {
            System.out.println("Task 3: " + i++);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Task3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
