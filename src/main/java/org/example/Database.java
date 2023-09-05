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
     * Pridani pojistence
     * @param pojistenec
     */
    public void addPojistence(Pojistenec pojistenec) {
        pojistenecMap.put(pojistenec.getCisloPojistence(), pojistenec);
    }

    /**
     * Hledani pojistence dle cisla pojistence
     * @param CisloPojistence cislo pojistence ktereho hledame
     * @return vraci nalezeho pojistence
     */
    public Pojistenec getPojistenceById(int CisloPojistence) {
        return pojistenecMap.get(CisloPojistence);
    }

    /**
     * metoda getPojistenceByTelefonniCislo ulozi pojistence do listu pro vypis pojistencu
     * @param telefonniCislo je String
     * @return vraci list nalezeniPojistenci
     */
    public List<Pojistenec> getPojistenceByTelefonniCislo(String telefonniCislo) {
        List<Pojistenec> nalezeniPojistenci = new ArrayList<>();

        for (Pojistenec pojistenec : pojistenecMap.values()) {
            if (pojistenec.getTelefonniCislo().toLowerCase().contains(telefonniCislo.toLowerCase())) {
                nalezeniPojistenci.add(pojistenec);
            }
        }

        return nalezeniPojistenci;
    }

    /**
     *  metoda getPojistenceByCeleJmeno ulozi pojistence do listu pro vypis pojistencu
     * @param krestniJmeno String
     * @param prijmeni String
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

    public void updatePojistence(Pojistenec pojistenec) {
        if (pojistenecMap.containsKey(pojistenec.getCisloPojistence())) {
            pojistenecMap.put(pojistenec.getCisloPojistence(), pojistenec);
        } else {
            throw new IllegalArgumentException("Pojistenec neni v databasi");
        }
    }

    public void deletePojistence(int CisloPojistence) {
        pojistenecMap.remove(CisloPojistence);
    }

    /**
     * metoda getAllPojistence pro vypis vsech pojistencu
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
