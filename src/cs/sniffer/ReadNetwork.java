/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.sniffer;

import db.Model;
import db.ModelDAO;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sijin
 */
public class ReadNetwork {

    public static void main(String[] args) {

        String START_STRING = "abadina";
        String END_STRING = "abadinz";

        AToZ aTOz = new AToZ(START_STRING);

        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("C:\\Users\\Sijin\\Desktop\\network");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            int count = 0;

            Model m;
            ModelDAO mdao = new ModelDAO();

            ArrayList<Integer> alist = new ArrayList<Integer>();
            ArrayList<String> blist = new ArrayList<String>();

            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                //     String a = "[51 Reassembled TCP Segments (73001 bytes): #21070(1460), #21071(1460), #21073(1460), #21074(1460), #21076(1460), #21077(1171), #21079(1460), #21080(1460), #21081(1460), #21082(1460), #21084(1460), #21085(1460), #21086(1460), #21087(1460), ]";
                count++;

                int temp = count % 11;
                if (temp == 8) {
                    String a = strLine;
                    a = a.replaceFirst(" byte.+$", "").replaceFirst("^.+\\(", "");
//                    System.out.println(START_STRING);
//                    System.out.println(a);
//                    System.out.println(Integer.parseInt(a));
                    alist.add(Integer.parseInt(a));
                    blist.add(START_STRING);

                    START_STRING = aTOz.getNextString();
                }


            }
            //Close the input stream
            in.close();


            for (int i = 0; i < alist.size(); i++) {
                System.out.println(blist.get(i));
                System.out.println(alist.get(i));

                m = new Model();

                m.setInfo(blist.get(i));
                m.setPacketsize(alist.get(i));

                mdao.create(m);
            }



        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

    }
}
