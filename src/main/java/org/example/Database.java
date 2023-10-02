package org.example;

import java.util.*;

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
     * @param hledanyText String // LJ vhodne jmeno parametru by bylo treba nameSubstring
     * @return vraci list nalezeniPojistenci
     */
    public List<Pojistenec> getPojistenceByCeleJmeno(String hledanyText) {
        List<Pojistenec> nalezeniPojistenci = new ArrayList<>();

        for (Pojistenec pojistenec : pojistenecMap.values()) {
            // LJ klidne pridat promennou `String hledanyTextLowercase = hledanyText.toLowerCase()` (az se jednou v budoucnu rozhodne ze vyhledavani je case-sensitive, je mensi sance ze to zapomenes zmenit na obou mistech) 
            if (pojistenec.getKrestniJmeno().toLowerCase().contains(hledanyText.toLowerCase()) || pojistenec.getPrijmeni().toLowerCase().contains(hledanyText.toLowerCase())) {
                nalezeniPojistenci.add(pojistenec);
            }
        }

        return nalezeniPojistenci;
    }

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
