package tvornicaSira.tableData;

import javafx.beans.property.SimpleStringProperty;

public class ImenikData {

    public String ime;
    public String firma;
    public String tipImenik;
    public String telefon;
    public String emailadresa;

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public void setTipImenik(String tipImenik) {
        this.tipImenik = tipImenik;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmailadresa(String emailadresa) {
        this.emailadresa = emailadresa;
    }

    public String getIme() {
        return ime;
    }

    public String getFirma() {
        return firma;
    }

    public String getTipImenik() {
        return tipImenik;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmailadresa() {
        return emailadresa;
    }

    

    public String toString() {
    return ime+" "+firma+" "+tipImenik+" "+telefon+" "+emailadresa;
    }
}
