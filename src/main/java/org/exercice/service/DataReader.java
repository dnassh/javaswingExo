package org.exercice.service;

import org.exercice.Main;
import org.exercice.model.Spectacle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

     public static List<Spectacle> read(String filename){
         List<Spectacle> listeDesSpectacles = new ArrayList<>();
         try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filename);
              BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

             String line;
             while ((line = br.readLine()) != null) {
                 String[] elems = line.split(";");
                 Spectacle spectacle = new Spectacle(
                         Integer.parseInt(elems[0]),
                         elems[1],
                         Integer.parseInt(elems[2]),
                         Integer.parseInt(elems[3]),
                         Double.parseDouble(elems[4])
                 );
                 listeDesSpectacles.add(spectacle);
             }
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }
         return listeDesSpectacles;
     }
}
