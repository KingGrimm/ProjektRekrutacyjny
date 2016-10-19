/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Random;

/**
 *
 * @author King
 */
@ManagedBean
@ApplicationScoped
public class names_database {

    private final static String[] names;
    private final static String[] surnames;

    static {
        names = new String[13];
        names[0] = "Abraham";
        names[1] = "Adrian";
        names[2] = "Felicja";
        names[3] = "Władysława";
        names[4] = "Izydor";
        names[5] = "Agaton";
        names[6] = "Franciszek";
        names[7] = "Edyta";
        names[8] = "Dominik";
        names[9] = "Julian";
        names[10] = "Lidia";
        names[11] = "Stanisław";
        names[12] = "Izydor";
    }

    static {
        surnames = new String[13];
        surnames[0] = "Kurek";
        surnames[1] = "Cieślak";
        surnames[2] = "Wójcik";
        surnames[3] = "Stępień";
        surnames[4] = "Krawczyk";
        surnames[5] = "Czyż";
        surnames[6] = "Kasprzyk";
        surnames[7] = "Lis";
        surnames[8] = "Cyps albo Zyps";
        surnames[9] = "Kołodziej";
        surnames[10] = "Piątek";
        surnames[11] = "Dudek";
        surnames[12] = "Czaja";

    }

    static public String getRandomName() {
        return names[(int) (Math.random() * 13)];
    }

    static public String getRandomSurname() {
        return surnames[(int) (Math.random() * 13)];
    }

    static public String getRandomNumber() {
        int max1 = 99;
        int min1 = 10;
        int max2 = 699;
        int min2 = 500;
        Random rand = new Random();
        int a = rand.nextInt((max1 - min1) + 1) + min1;
        int b = rand.nextInt((max2 - min2) + 1) + min2;
        int c = rand.nextInt((max1 - min1) + 1) + min1;
        int d = rand.nextInt((max1 - min1) + 1) + min1;
        int e = rand.nextInt((max1 - min1) + 1) + min1;
        System.out.println("Wynik losowania numeru: " + "+(" + a + ")" + b + "-" + (int) c + "-" + (int) d + "-" + (int) e);

        return "+(48) " + b + "-" + (int) c + "-" + (int) d + "-" + (int) e;
    }
}
