/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.program;

import cs.component.CPUIntensive;
import cs.component.ComponentIntensive;

/**
 *
 * @author Sijin
 */
public class Program3 extends Program {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            ComponentIntensive ci;

            ci = new CPUIntensive();

            ci.execute();
        }
    }
}
