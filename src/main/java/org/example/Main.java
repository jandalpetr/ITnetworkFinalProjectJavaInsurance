package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        // Pridani pojistenc
        Pojistenec pojistenec1 = new Pojistenec(0,"John", "Doe", 30, "+123456789");
        Pojistenec pojistenec2 = new Pojistenec(0,"Petr", "Novak", 25, "+987654321");
        Pojistenec pojistenec3 = new Pojistenec(0,"Martin", "Homola", 26, "+987654322");
        Pojistenec pojistenec4 = new Pojistenec(0,"Petr", "Jandal ", 27, "+987654323");
        Pojistenec pojistenec5 = new Pojistenec(0,"Honza", "Marousek", 28, "+987654324");

        database.addPojistence(pojistenec1);
        database.addPojistence(pojistenec2);
        database.addPojistence(pojistenec3);
        database.addPojistence(pojistenec4);
        database.addPojistence(pojistenec5);

        // Nalezeni pojistence dle cislaPojistence
        Pojistenec nalezenyPojistenec = database.getPojistenceById(1);
        System.out.println("Nalezeny pojistenec: " + nalezenyPojistenec.getKrestniJmeno() + " " + nalezenyPojistenec.getPrijmeni() +" "+ nalezenyPojistenec.getVek() +" "+ nalezenyPojistenec.getTelefonniCislo());

        //Nalezeni pojistencu dle telefonniho cisla
        List<Pojistenec> nalezeniPojistenciByTelefonniCislo = database.getPojistenceByTelefonniCislo ("8");
        // Vypis nalezenych pojistencu
        System.out.println("Nalezeni Pojistenci dle Telefonniho cisla:");
        TiskPojistencu.tiskNalezeniPojistenci(nalezeniPojistenciByTelefonniCislo);

        //Nalezeni pojistencu dle Jmena a Prijmeni
        List<Pojistenec> nalezeniPojistenciByCeleJmeno = database.getPojistenceByCeleJmeno ("Petr");
        // Vypis nalezenych pojistencu
        System.out.println("Nalezeni Pojistenci dle Jmena nebo Prijmeni:");
        TiskPojistencu.tiskNalezeniPojistenci(nalezeniPojistenciByCeleJmeno);

        // Aktualizace veku pojistence
        nalezenyPojistenec.setVek(31);
        database.updatePojistence(nalezenyPojistenec);

        // Vymazani pojistence
        //database.deletePojistence(2);

        // Vypis vsech pojistencu
        List<Pojistenec> vypisVsechPojistencu = database.getAllPojistenci ();
        // Vypis nalezenych pojistencu
        System.out.println("Vsichni Pojistenci:");
        TiskPojistencu.tiskNalezeniPojistenci(vypisVsechPojistencu);

    }
}
