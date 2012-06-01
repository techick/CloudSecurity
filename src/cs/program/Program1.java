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
public class Program1 extends Program {

    @Override
    public void run() {
        ComponentIntensive ci;

        ci = new CPUIntensive();

        ci.execute();

        ci = new MemoryIntensive();

        ci.execute();
    }
}
