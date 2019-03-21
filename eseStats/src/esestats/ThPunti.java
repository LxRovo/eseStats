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
public class ThPunti extends Thread {

    private DatiCondivisi ptrDati;

    public ThPunti(DatiCondivisi dati) {
        ptrDati = dati;
    }

    public void run() {
        try {
            for (int i = 0; i < ptrDati.getNumCaratteri(); i++) {
                ptrDati.WaitSem2();

                if (ptrDati.getCarattereEstratto() == '.') {
                    ptrDati.setNumPuntiLetti(ptrDati.getNumPuntiLetti() + 1);
                }

                ptrDati.SignalSem3();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThPunti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
