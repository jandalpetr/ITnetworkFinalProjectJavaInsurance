package org.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
