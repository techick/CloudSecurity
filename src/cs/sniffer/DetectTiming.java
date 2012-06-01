/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.sniffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author Sijin
 */
public class DetectTiming {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();

        list.add("http://146.169.35.38/test/ProgramOne");
        list.add("http://146.169.35.38/test/ProgramTwo");
        list.add("http://146.169.35.38/test/ProgramThree");

        for (int i = 0; i < 10; i++) {


            Random randomGenerator = new Random();

            int randomInt = randomGenerator.nextInt(3);

            String url = list.get(randomInt);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            URL oracle = null;
            try {
                oracle = new URL(url);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            URLConnection yc = null;
            try {
                yc = oracle.openConnection();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader in = null;

            try {
                in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            String inputLine;
            try {
                while ((inputLine = in.readLine()) != null) {

                    // System.out.println(inputLine);
                    if (inputLine.equalsIgnoreCase("35")) {
                        System.out.println("Program One");


                    }

                    if (inputLine.equalsIgnoreCase("30")) {
                        System.out.println("Program Two");
                    }

                    if (inputLine.equalsIgnoreCase("28")) {
                        System.out.println("Program Three");
                    }

                    int input = Integer.parseInt(inputLine);

                    ArrayList<Integer> alist;
                    alist = getAverageCPU(input);
                   

                    System.out.println("CPU: " + alist.get(0));
                    System.out.println("Memory: " + alist.get(1));

                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static ArrayList<Integer> getAverageCPU(int input) {

        ArrayList<Integer> alist = new ArrayList<Integer>();

 

        String id = "799d544a-6e61-4bdf-9ef8-1f32ad2673ef";

        long period = input * 1000;

        long timeInMillis = System.currentTimeMillis();


        long end = timeInMillis;

        long start = end - period;


        String url = "http://barking01.doc.ic.ac.uk:8080/EACCloudControl/APPHistory?";
        url += "containerid=" + id + "&";
        url += "startdate=" + start + "&";
        url += "enddate=" + end + "&";
        url += "timeinterval=" + period;

        System.out.println(url);

        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                
                JSONObject json = (JSONObject) JSONSerializer.toJSON(inputLine);

                JSONArray usage = json.getJSONArray("usages");

                JSONObject object = usage.getJSONObject(0);

                int cpu = object.getInt("cpuresponsetime");
                int memory = object.getInt("usedmemory");

                alist.add(cpu);
                alist.add(memory);
  



            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(DetectTiming.class.getName()).log(Level.SEVERE, null, ex);
        }

        return alist;
    }


}
