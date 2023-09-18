package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private Map<Integer, Pojistenec> pojistenecMap;

    public Database() {
        pojistenecMap = new HashMap<>();
    }

    /**
     * Pridani pojistence, akcteptuje duplicitni zaznam.
     *
     * @param pojistenec objekt pojistence
     */
    public void addPojistence(Pojistenec pojistenec) {
        pojistenecMap.put(pojistenec.getCisloPojistence(), pojistenec);
    }

    /**
     * metoda zajistujici
     *
     * @param pojistenec objekt vkladaneho pojistence
     * @return vraci true paklize byl nalezen shodny zaznam
     */
    public boolean jeDuplicitni(Pojistenec pojistenec) {
        for (Pojistenec pojistenecUlozeny : pojistenecMap.values()) {
            if (pojistenecUlozeny.getKrestniJmeno().equalsIgnoreCase(pojistenec.getKrestniJmeno())
                    && pojistenecUlozeny.getPrijmeni().equalsIgnoreCase(pojistenec.getPrijmeni())
                    && pojistenecUlozeny.getVek() == pojistenec.getVek()
                    && pojistenecUlozeny.getTelefonniCislo().equalsIgnoreCase(pojistenec.getTelefonniCislo())) {
                return true;
                //pojistenec se shodnymi atributy
            }
        }
        // Pojistenec nenalezen
        return false;
    }


    /**
     * metoda getPojistenceByCeleJmeno ulozi pojistence do listu pro vypis pojistencu
     *
     * @param hledanyText String
     * @return vraci list nalezeniPojistenci
     */
    public List<Pojistenec> getPojistenceByCeleJmeno(String hledanyText) {
        List<Pojistenec> nalezeniPojistenci = new ArrayList<>();

        for (Pojistenec pojistenec : pojistenecMap.values()) {
            if (pojistenec.getKrestniJmeno().toLowerCase().contains(hledanyText.toLowerCase()) || pojistenec.getPrijmeni().toLowerCase().contains(hledanyText.toLowerCase())) {
                nalezeniPojistenci.add(pojistenec);
            }
        }

        return nalezeniPojistenci;
    }

     /**
     * metoda neni vyzadovana v zadani a tak neni vyuzita v tride administrace
     * Mazani pojistence dle CislaPojistence
     *
     * @param CisloPojistence unikatni cislo pojistence
     */

    /**
     * metoda getAllPojistence pro vypis vsech pojistencu
     *
     * @return vraci kolekci vsech pojistencu
     */
    public List<Pojistenec> getAllPojistenci() {
        List<Pojistenec> nalezeniPojistenci = new ArrayList<>();

        for (Pojistenec pojistenec : pojistenecMap.values()) {
            nalezeniPojistenci.add(pojistenec);
        }

        return nalezeniPojistenci;
    }
}
