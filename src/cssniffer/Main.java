/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cssniffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //http and ip.src==188.40.33.19 and ip.dst==146.169.6.76 and http.response.code==200
    public static void main(String[] args) {
        // TODO code application logic here

        String START_STRING = "abadina";
        String END_STRING = "abadinz";

        AToZ aTOz = new AToZ(START_STRING);

        

        while (true) {

            System.out.println(START_STRING);

            String term = START_STRING;

            String url = "http://ws.geonames.org/searchJSON";
            url += "?";
            url += "featureClass=P";
            url += "&";
            url += "style=full";
            url += "&";
            url += "maxRows=100";
            url += "&";
            url += "country=uk";
            url += "&";
            url += "name_startsWith=" + term;

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

                    System.out.println(inputLine.length());

                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            START_STRING = aTOz.getNextString();

            if (START_STRING.equals(END_STRING)) {

                System.out.println(START_STRING);

                term = START_STRING;

                url = "http://ws.geonames.org/searchJSON";
                url += "?";
                url += "featureClass=P";
                url += "&";
                url += "style=full";
                url += "&";
                url += "maxRows=100";
                url += "&";
                url += "country=uk";
                url += "&";
                url += "name_startsWith=" + term;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                oracle = null;
                try {
                    oracle = new URL(url);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                yc = null;
                try {
                    yc = oracle.openConnection();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                in = null;

                try {
                    in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    while ((inputLine = in.readLine()) != null) {

                        System.out.println(inputLine.length());

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }


                break;
            }


            //  }
        }

    }
}
