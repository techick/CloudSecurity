/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.component;

import cs.maths.Factorial;
import java.math.BigInteger;

/**
 *
 * @author Sijin
 */
public class CPUIntensive extends ComponentIntensive {

    @Override
    public void execute() {

       
            BigInteger n = Factorial.Factorial(2000);

       

    }
}
