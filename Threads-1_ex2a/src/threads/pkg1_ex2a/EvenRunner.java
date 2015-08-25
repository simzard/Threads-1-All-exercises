/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pkg1_ex2a;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class EvenRunner implements Runnable {

    Even evenObject = null;

    String name = null;
    
    public EvenRunner(Even e, String n) {
        evenObject = e;
        name = n;
    }

    @Override
    public void run() {
        while(true) {
            int nextNum = evenObject.next();
            //System.out.print(nextNum);
            if (nextNum % 2 == 0)
                System.out.println(name + ": even");
            else 
                System.out.println(name + ": NOT even"); // <--- THIS will probably happen some time!
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(EvenRunner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
