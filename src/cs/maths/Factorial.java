/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.maths;

import java.math.BigInteger;

/**
 *
 * @author Sijin
 */
public class Factorial {

    public static BigInteger Factorial(int value) {


        BigInteger n = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            n = n.multiply(BigInteger.valueOf(i));
            System.out.println(i + "! = " + n);
        }

        return n;

    }
}
