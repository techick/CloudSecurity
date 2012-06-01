/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.sniffer;

import java.io.*;

/**
 *@author  comstep
 *@website http://www.blogjava.net/tripper
 */
public class AToZ {

    private String str = "";
    private int length = 0;
    private char[] ch;

    public AToZ(String str) {
        this.str = str;
        this.length = str.length();
        this.ch = str.toCharArray();
    }

    public String getNextString() {
        for (int i = 0, j = length - 1; i < length && j >= 0; i++) {
            if (ch[j] != 'z') {
                ch[j]++;
                break;
            } else {
                ch[j] = 'a';
                j--;
                continue;
            }
        }

        return new String(ch);
    }

    public static void main(String[] args) throws Exception {
        String START_STRING = "aaa";
        String END_STRING = "zzz";

        AToZ aTOz = new AToZ(START_STRING);

        FileOutputStream fout = new FileOutputStream("out.txt");

        PrintWriter printWriter = new PrintWriter(fout);

        printWriter.println(START_STRING);

        int count = 1;

        while (true) {
            START_STRING = aTOz.getNextString();

            printWriter.println(START_STRING);

            System.out.println(START_STRING);

            count++;

            if (START_STRING.equals(END_STRING)) {
                break;
            }
        }

        printWriter.println("共：" + count + " 个");

        System.out.println("共：" + count + " 个");

        printWriter.close();
        fout.close();
    }
}
