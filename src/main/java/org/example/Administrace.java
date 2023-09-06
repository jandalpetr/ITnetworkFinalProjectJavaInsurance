package org.example;
import java.util.List;
import java.util.Scanner;

public class Administrace {
    Scanner scanner = new Scanner(System.in, "Windows-1250");
    Database database = new Database();
    InputValidator inputValidator= new InputValidator(scanner);
    //Administrace administrace = new Administrace();

    /**
     * Start aplikace
     */
    public void start() {
        String volba = "";
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
        // hlavní cyklus
        while (!volba.equals("4")) {
            //diar.vypisUvodniObrazovku();
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("Evidence pojistenych");
            System.out.println("--------------------------------------------------");
            System.out.println("Vyberte si akci:");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného dle jména nebo příjmení");
            System.out.println("4 - Konec");
            volba = scanner.nextLine();
            System.out.println();
            // reakce na volbu
            switch (volba) {
                case "1":
                    //"1 - Přidat nového pojištěného"
                    pridatPojistence();
                    break;
                case "2":
                    //"2 - Vypsat všechny pojištěné"
                    vypisVsechPojistencu();
                    break;
                case "3":
                    //3 - Vyhledat pojištěného dle jména nebo příjmení"
                    nalezeniPojistenciByCeleJmeno();
                    break;
                case "4":
                    // vyskočí z cyklu while a tím ukončí program
                    //"4 - Konec"
                    break;
                default:
                    System.out.println("Neplatná volba, stiskněte libovolnou klávesu a opakujte volbu.");
                    break;
            }
        }
        // pred ukoncenim uzavreme scanner
        scanner.close();
    }

    public void pridatPojistence(){
        String krestniJmeno=inputValidator.getNeprazdnyRetezec("Zadejte krestni jmeno pojisteneho:");
        String prijmeni=inputValidator.getNeprazdnyRetezec("Zadejte prijmeni pojisteneho:");
        int vek=inputValidator.getNezaporneCislo("Zadejte vek pojisteneho:");
        String telefonniCislo=inputValidator.getNeprazdnyRetezec("Zadejte telefonni cislo vcetne predvoby ve formatu +4200000000: ");//ToDo toto jeste musim dodelat

        Pojistenec pojistenec = new Pojistenec(0,krestniJmeno, prijmeni, vek, telefonniCislo);
        database.addPojistence(pojistenec);

        System.out.println(" ");
        System.out.println("Pojistenec pridan.");
    }
    /**
     * Vypise vsechny pojistence v databasi, pokud je database prazdna, upozoroni na to.
     */
    public void vypisVsechPojistencu(){
        // Vypis vsech pojistencu
        List<Pojistenec> vypisVsechPojistencu = database.getAllPojistenci ();
        if(vypisVsechPojistencu.isEmpty()){
            System.out.println("Database pojistencu je prazdna, zadejte volbu 1:");
        }else {
            // Vypis nalezenych pojistencu
            System.out.println("Vsichni Pojistenci:");
            TiskPojistencu.tiskNalezeniPojistenci(vypisVsechPojistencu);
        }
    }

    /**
     * Nalezeni pojistencu dle Jmena nebo Prijmeni
     */
    public void nalezeniPojistenciByCeleJmeno(){
        System.out.print("Pro vyhledani pojistence, zadejte i cast jmena nebo prijmeni : ");
        String searchString = scanner.nextLine();
        if (searchString.isEmpty()){
            System.out.println("Nic jste nezadali, vratim Vas do hlavniho menu");
        }else {
            List<Pojistenec> nalezeniPojistenciByCeleJmeno = database.getPojistenceByCeleJmeno (searchString);
            // Vypis nalezenych pojistencu
            System.out.println("Nalezeni Pojistenci dle Jmena nebo Prijmeni :"+searchString );
            TiskPojistencu.tiskNalezeniPojistenci(nalezeniPojistenciByCeleJmeno);
        }
    }
}
