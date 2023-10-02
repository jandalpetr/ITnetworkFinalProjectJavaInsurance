package org.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// LJ chvalim pridani testu. Ty by vsak mely byt ve slozce `test`, ne ve slozce `src`, aby se daly jednoduse poustet pomoci `mvn test`
// obecne tech testu pridat co nejvic a pro co nejvic trid - mimo jine to pomaha napsat citelnejsi a dobre testovatelny program
public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
        // Add some sample customers for testing
        Pojistenec pojistenec1 = new Pojistenec(1, "John", "Doe", 30, "+123456789");
        Pojistenec pojistenec2 = new Pojistenec(2, "Alice", "Smith", 25, "+987654321");
        database.addPojistence(pojistenec1);
        database.addPojistence(pojistenec2);
    }

    // LJ radsi rozdelit do dvou testu a vhodne testy pojmenovat, pak neni treba komentaru a kdyz test spadne, hned je z nazvu spadleho testu jasne. kde je chyba.
    // Zde treba `testJeDuplicitini should return true for user with all same fields` a `testJeDuplicitini should return false for user with same number but different name`
    @Test
    public void testJeDuplicitni() {
        // Test na duplicitniho pojistence
        Pojistenec pojistenec11 = new Pojistenec(1, "John", "Doe", 30, "+123456789");
        assertTrue(database.jeDuplicitni(pojistenec11));

        // Test pro neduplicitniho pojistence
        Pojistenec pojistenec21 = new Pojistenec(2, "Bob", "Smith", 35, "+555555555");
        assertFalse(database.jeDuplicitni(pojistenec21));
    }
}
