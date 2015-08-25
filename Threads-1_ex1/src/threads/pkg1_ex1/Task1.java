/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pkg1_ex1;

/**
 *
 * @author simon
 */
public class Task1 implements Runnable {

    @Override
    public void run() {
        long sum = 0;
        for (int i = 1; i < 1000000000; ++i) {
            sum += i;
        }

        System.out.println("Task 1: The sum of 1 + 2 + ... + 1000000000 = " + sum);
    }

}
