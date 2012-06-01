/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.program;

/**
 *
 * @author Sijin
 */
public abstract class Program {

    public abstract void run();

    public static void main(String[] args) {

        Program p;

        long startTime = System.currentTimeMillis();
       // p = new ProgramOne(); 43
        //p = new ProgramTwo();
        p = new Program3();


        p.run();
        long endTime = System.currentTimeMillis();

        long time = (endTime-startTime)/1000;
        System.out.println("Execution Time: " + time);
    }
}
