package org.exercice;

import org.exercice.model.Spectacle;
import org.exercice.service.DataReader;


import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Spectacle> listeDesSpectacles = new ArrayList<>();
    public static void main(String[] args) {

        String fileName = "spectacles.txt";
        listeDesSpectacles = DataReader.read(fileName);
        System.out.println(listeDesSpectacles);

    }
}