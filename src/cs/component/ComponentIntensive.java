/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.component;

/**
 *
 * @author Sijin
 */
public abstract class ComponentIntensive {

    public ComponentIntensive(){
        
    }

    abstract public void execute();


    public static void main(String[] args) {
        ComponentIntensive ci;

     //   ci = new CPUIntensive();

     //   ci.execute();

        ci = new MemoryIntensive();

        ci.execute();
    }
}
