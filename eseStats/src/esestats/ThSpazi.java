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
public class ThSpazi extends Thread {

    private DatiCondivisi ptrDati;

    public ThSpazi(DatiCondivisi dati) {
        ptrDati = dati;
    }

    public void run() {
        try {
            for (int i = 0; i < ptrDati.getNumCaratteri(); i++) {
                ptrDati.WaitSem3();

                if (ptrDati.getCarattereEstratto() == ' ') {
                    ptrDati.setNumSpaziLetti(ptrDati.getNumSpaziLetti() + 1);
                }

                ptrDati.SignalSem4();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThSpazi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
