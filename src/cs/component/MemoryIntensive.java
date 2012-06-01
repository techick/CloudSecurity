/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijin
 */
public class MemoryIntensive extends ComponentIntensive {

    @Override
    public void execute() {

        char[] anArray;



        for(int i =0; i < 10; i++){

            try {


                anArray = new char[49999999];

                anArray[0] = '0';
                Thread.sleep(1000);
                anArray[1] = '1';
                Thread.sleep(1000);
                anArray[2] = '2';
                Thread.sleep(1000);


            } catch (InterruptedException ex) {
                Logger.getLogger(MemoryIntensive.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
}
