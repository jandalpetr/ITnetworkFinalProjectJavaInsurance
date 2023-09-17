package org.example;

public class Pojistenec {
    private static int dalsiCisloPojistence = 1; //staticke pocatecni cislo pojistnce
    private int cisloPojistence; // unikatni cislo pojistnec
    private String krestniJmeno; //Krestni jmeno pojistence
    private String prijmeni; //Prijmeni pojistence
    private int vek;//vek pojistence v letech
    private String telefonniCislo; // Telefonn cislo ukladame jak text vcetne predvolby

    // konstruktor pro inizializaci objektu Pojistenec
    public Pojistenec(int cisloPojistence, String krestniJmeno, String prijmeni, int vek, String telefonniCislo) {
        if (vek < 0 || vek > 200) {
            throw new IllegalArgumentException("Vek nemuze byt zaporny a vetsi nez 200let.");
        }
        if (telefonniCislo == null || telefonniCislo.isEmpty()) {
            throw new IllegalArgumentException("Telefonni cislo nemuze byt prazdne.");
        }
        if (krestniJmeno.isEmpty()) {
            throw new IllegalArgumentException("Krestni nesmi byt prazdne.");
        }
        if (prijmeni.isEmpty()) {
            throw new IllegalArgumentException("Prijmeni nesmi byt prazdne.");
        }

        this.cisloPojistence = dalsiCisloPojistence++;
        this.krestniJmeno = krestniJmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    // Getters and setters for all fields

    public int getCisloPojistence() {
        return cisloPojistence;
    }

    public void setCisloPojistence(int cisloPojistence) {
        this.cisloPojistence = cisloPojistence;
    }

    public String getKrestniJmeno() {
        return krestniJmeno;
    }

    public void setKrestniJmeno(String krestniJmeno) {
        if (krestniJmeno.isEmpty()) {
            throw new IllegalArgumentException("Krestni nesmi byt prazdne.");
        }
        this.krestniJmeno = krestniJmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        if (prijmeni.isEmpty()) {
            throw new IllegalArgumentException("Prijmeni nesmi byt prazdne.");
        }
        this.prijmeni = prijmeni;
    }


    public void setVek(int vek) {
        if (vek < 0 || vek > 200) {
            throw new IllegalArgumentException("Vek nemuze byt zaporny a vetsi nez 200let.");
        }
        this.vek = vek;
    }

    public int getVek() {
        return vek;
    }

    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    public void setTelefonniCislo(String telefonniCislo) {
        if (telefonniCislo == null || telefonniCislo.isEmpty()) {
            throw new IllegalArgumentException("Telefonni cislo nemuze byt prazdne");
        }
        this.telefonniCislo = telefonniCislo;
    }
}