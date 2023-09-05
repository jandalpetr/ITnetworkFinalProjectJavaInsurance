package org.example;

import java.util.List;

/**
 * Trida pro tisk pojistencu
 */
public class TiskPojistencu {
    /**
     * metoda pro tisk vysledku do sloupcu
     * @param nalezeniPojistenci list nalezenych pojistencu
     */
    public static void tiskNalezeniPojistenci(List<Pojistenec> nalezeniPojistenci) {
        int maxKrestniJmenoDelka = 0;
        int maxPrijmeniDelka = 0;
        int maxVekDelka =0;
        int maxTelefonniCisloDelka = 0;

        // Nalezeni maximalni sirky sloupcu
        for (Pojistenec pojistenec : nalezeniPojistenci) {
            maxKrestniJmenoDelka = Math.max(maxKrestniJmenoDelka, pojistenec.getKrestniJmeno().length());
            maxPrijmeniDelka = Math.max(maxPrijmeniDelka, pojistenec.getPrijmeni().length());
            maxVekDelka = Math.max(maxVekDelka, String.valueOf(pojistenec.getVek()).length());
            maxTelefonniCisloDelka = Math.max(maxTelefonniCisloDelka, pojistenec.getTelefonniCislo().length());
        }

        // Tisk pojistencu zarovnano do sloupcu
        for (Pojistenec pojistenec : nalezeniPojistenci) {
            System.out.printf(
                    "%-" + maxKrestniJmenoDelka + "s  %-" + maxPrijmeniDelka +"s  %-" + maxVekDelka + "s  %-" + maxTelefonniCisloDelka + "s%n",
                    pojistenec.getKrestniJmeno(),
                    pojistenec.getPrijmeni(),
                    pojistenec.getVek(),
                    pojistenec.getTelefonniCislo()
            );
        }
    }
}

