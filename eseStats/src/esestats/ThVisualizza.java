/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestats;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rovelli_andrea
 */
public class ThVisualizza extends Thread {

    private DatiCondivisi ptrDati;

    public ThVisualizza(DatiCondivisi dati) {
        ptrDati = dati;
    }

    public void run() {
        try {
            for (int i = 0; i < ptrDati.getNumCaratteri(); i++) {
                ptrDati.WaitSem4();

                System.out.println("----------------------------------------------");
                System.out.println(ptrDati.getBuffer().toString());
                System.out.println("Il numero di spazi inseriti: " + ptrDati.getNumSpaziInseriti());
                System.out.println("Il numero di punti inseriti: " + ptrDati.getNumPuntiInseriti());
                System.out.println("Il numero di spazi letti: " + ptrDati.getNumSpaziLetti());
                System.out.println("Il numero di punti letti: " + ptrDati.getNumPuntiLetti());
                System.out.println("----------------------------------------------");

                ptrDati.SignalSem1();
            }

            ptrDati.SignalSemJoin();

        } catch (InterruptedException ex) {
            Logger.getLogger(ThVisualizza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
