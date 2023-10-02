package org.example;

import java.util.List;
import java.util.Scanner;

public class Administrace {
    Scanner scanner = new Scanner(System.in, "Windows-1250");
    Database database = new Database();
    InputValidator inputValidator = new InputValidator(scanner);
    //Administrace administrace = new Administrace();

    // LJ vyhnout se michani cestiny a anglictiny, chapu ze zde zadani vyzadovalo cestinu. Idealne anglictina vsude - dokumentace, kod, javadoc
    /**
     * Start aplikace
     */
    public void start() {
        String volba = "";
        // hlavní cyklus
        while (!volba.equals("4")) {
            // LJ smazat zakomentovany kod, pravdepodobne ho nikdy nikdo uz neodkomentuje (a kdyz by ho presto chtel pouzit, podiva se do historie diky GITu)
            //diar.vypisUvodniObrazovku();
            // LJ nebat se rozdelit na vice mensich metod delajicich jednu vec. Zde treba:
            // while (!volba.equals("4")) {
            //   printInstructionsToConsole();
            //    volba = scanner.nextLine();
            //    System.out.println();
            //    doAction(volba)    // do doAction() bys schoval celou tu swich(..){..} logiku
            // 
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("Evidence pojistenych");
            System.out.println("--------------------------------------------------");
            System.out.println("Vyberte si akci:");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného dle jména nebo příjmení");
            System.out.println("4 - Konec");
            System.out.println("5 - Naplneni testovacimi daty");
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
                case "5":
                    // 5- Naplneni testovacimi daty
                    naplneniTestDaty();
                    break;
                default:
                    System.out.println("Neplatná volba, stiskněte libovolnou klávesu a opakujte volbu.");
                    break;
            }
        }
        // pred ukoncenim uzavreme scanner
        scanner.close();
    }

    // LJ metody, ktere nejsou volany z jinych trid, udelat private
    /**
     * pri pridani pojistence probiha kontrola
     * -na format vlozenych dat
     * -kontrola zda stejny pojistenec jiz nebyl zadan (toto neni vyslovne v zadani)
     */
    public void pridatPojistence() {
        String krestniJmeno = inputValidator.getNeprazdnyRetezec("Zadejte krestni jmeno pojisteneho:");
        String prijmeni = inputValidator.getNeprazdnyRetezec("Zadejte prijmeni pojisteneho:");
        int vek = inputValidator.getNezaporneCislo("Zadejte vek pojisteneho:");
        String telefonniCislo = inputValidator.getNeprazdnyRetezec("Zadejte telefonni cislo vcetne predvoby ve formatu +00000000: ");//ToDo toto musim jeste vylepsi Regex na mezinarodni kod

        // Kontrola zda stejny pojistenec jiz nebyl zadan (toto neni vyslovne v zadani)
        // LJ cislo pojistence by asi melo byt bud zadano nebo treba nahodne (Math.random)
        Pojistenec pojistenec = new Pojistenec(0, krestniJmeno, prijmeni, vek, telefonniCislo);
        boolean jeDuplicitniPojistenec = database.jeDuplicitni(pojistenec);

        if (jeDuplicitniPojistenec) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Pojistened nebude pridan. Stejny pojistenec jiz byl zadan v databasi");
            System.out.println(" ");
            System.out.println(" ");
        } else {
            database.addPojistence(pojistenec);
            System.out.println(" ");
            System.out.println("Pojistenec pridan.");
            System.out.println(" ");
        }
    }

    // LJ obecne bych se vice vyhybal `void` metodam a vracel z nich radsi boolean:
    // - treba v pripade uspesne operace vrati true, jinak false.
    // - pak muzes treba logovat/vypisovat na jednom miste vsechny neuspesne operace
    // - a predevsim to je lepe testovatelny - void metody se testuji tezko
    /**
     * Vypise vsechny pojistence v databasi, pokud je database prazdna, upozoroni na to.
     */
    public void vypisVsechPojistencu() {
        // Vypis vsech pojistencu
        List<Pojistenec> vypisVsechPojistencu = database.getAllPojistenci();
        if (vypisVsechPojistencu.isEmpty()) {
            System.out.println("Database pojistencu je prazdna, zadejte volbu 1:");
        } else {
            // Vypis nalezenych pojistencu
            System.out.println("Vsichni Pojistenci:");
            TiskPojistencu.tiskNalezeniPojistenci(vypisVsechPojistencu);
        }
    }

    /**
     * Nalezeni pojistencu dle Jmena nebo Prijmeni -neni Case Sensitive
     */
    public void nalezeniPojistenciByCeleJmeno() {
        System.out.print("Pro vyhledani pojistence, zadejte i cast jmena nebo prijmeni (neni Case Sensitive): ");
        String searchString = scanner.nextLine();
        if (searchString.isEmpty()) {
            System.out.println("Nic jste nezadali, vratim Vas do hlavniho menu");
        } else {
            List<Pojistenec> nalezeniPojistenciByCeleJmeno = database.getPojistenceByCeleJmeno(searchString);
            // Vypis nalezenych pojistencu
            System.out.println("Nalezeni Pojistenci dle Jmena nebo Prijmeni :" + searchString);
            TiskPojistencu.tiskNalezeniPojistenci(nalezeniPojistenciByCeleJmeno);
        }
    }

    /**
     * Metoda pro pridani vzorovych dat do database
     */
    public void naplneniTestDaty() {
        //Pridani pojistenc
        Pojistenec pojistenec1 = new Pojistenec(1, "John", "Doe", 30, "+123456789");
        Pojistenec pojistenec2 = new Pojistenec(2, "Petr", "Novak", 25, "+987654321");
        Pojistenec pojistenec3 = new Pojistenec(3, "Martin", "Homola", 26, "+987654322");
        Pojistenec pojistenec4 = new Pojistenec(4, "Petr", "Jandal ", 27, "+987654323");
        Pojistenec pojistenec5 = new Pojistenec(5, "Honza", "Marousek", 28, "+987654324");

        database.addPojistence(pojistenec1);
        database.addPojistence(pojistenec2);
        database.addPojistence(pojistenec3);
        database.addPojistence(pojistenec4);
        database.addPojistence(pojistenec5);
        System.out.println("Testovaci data pojistencu byla vlozena.");
    }
}
