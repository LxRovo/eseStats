/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestats;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rovelli_andrea
 */
public class EseStats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            DatiCondivisi dati = new DatiCondivisi();
            ThGeneraCaratteri th1 = new ThGeneraCaratteri(dati);
            ThPunti th2 = new ThPunti(dati);
            ThSpazi th3 = new ThSpazi(dati);
            ThVisualizza th4 = new ThVisualizza(dati);

            System.out.println("Inserire il numero di caratteri che si vuole generare:");
            int CarDaGenerare = input.nextInt();
            dati.setNumCaratteri(CarDaGenerare);

            th1.start();
            th2.start();
            th3.start();
            th4.start();

            dati.WaitSemJoin();

            System.out.println("Programma terminato");
        } catch (InterruptedException ex) {
            Logger.getLogger(EseStats.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
