/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.program;

import cs.component.CPUIntensive;
import cs.component.ComponentIntensive;
import cs.component.MemoryIntensive;

/**
 *
 * @author Sijin
 */
public class Program2 extends Program {

    @Override
    public void run() {

        for (int i = 0; i < 1; i++) {
            ComponentIntensive ci;

            ci = new MemoryIntensive();

            ci.execute();
        }

    }
}
