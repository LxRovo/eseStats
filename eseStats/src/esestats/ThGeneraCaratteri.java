/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestats;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rovelli_andrea
 */
public class ThGeneraCaratteri extends Thread {

    private char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ' ', '.', ' ', '.'};
    private DatiCondivisi ptrDati;

    public ThGeneraCaratteri(DatiCondivisi dati) {
        ptrDati = dati;
    }

    public void run() {
        try {
            for (int i = 0; i < ptrDati.getNumCaratteri(); i++) {

                Random rand = new Random();
                int NumRand = rand.nextInt(array.length);

                ptrDati.WaitSem1();
                ptrDati.setCarattereEstratto(array[NumRand]);
                ptrDati.getBuffer().add(String.valueOf(ptrDati.getCarattereEstratto()));
                if (ptrDati.getCarattereEstratto() == '.') {
                    ptrDati.setNumPuntiInseriti(ptrDati.getNumPuntiInseriti() + 1);
                }
                if (ptrDati.getCarattereEstratto() == ' ') {
                    ptrDati.setNumSpaziInseriti(ptrDati.getNumSpaziInseriti() + 1);
                }

                ptrDati.SignalSem2();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThGeneraCaratteri.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
