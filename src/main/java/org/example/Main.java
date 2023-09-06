package org.example;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "Windows-1250");
        Database database = new Database();
        Administrace administrace = new Administrace();
        administrace.start();
/*

        // Nalezeni pojistence dle cislaPojistence
        Pojistenec nalezenyPojistenec = database.getPojistenceById(1);
        System.out.println("Nalezeny pojistenec: " + nalezenyPojistenec.getKrestniJmeno() + " " + nalezenyPojistenec.getPrijmeni() +" "+ nalezenyPojistenec.getVek() +" "+ nalezenyPojistenec.getTelefonniCislo());

        //Nalezeni pojistencu dle telefonniho cisla
        List<Pojistenec> nalezeniPojistenciByTelefonniCislo = database.getPojistenceByTelefonniCislo ("8");
        // Vypis nalezenych pojistencu
        System.out.println("Nalezeni Pojistenci dle Telefonniho cisla:");
        TiskPojistencu.tiskNalezeniPojistenci(nalezeniPojistenciByTelefonniCislo);

        // Aktualizace veku pojistence
//        nalezenyPojistenec.setVek(31);
//        database.updatePojistence(nalezenyPojistenec);

        // Vymazani pojistence
        //database.deletePojistence(2);
*/


    }
}
