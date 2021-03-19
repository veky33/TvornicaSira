package tvornicaSira.tableData;

import java.util.Date;

public class IstorijaData extends SirData {
    public Date datum;
    public String izSkladista;
     public String USkladiste;
    public String unSkladiste;

    public Date getDatum() {
        return datum;
    }

    public String getIzSkladista() {
        return izSkladista;
    }
    
    public String getUSkladiste() {
        return izSkladista;
    }

    public String getUnSkladiste() {
        return unSkladiste;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setIzSkladista(String izSkladista) {
        this.izSkladista = izSkladista;
    }
    
     public void setUSkladiste(String USkladiste) {
        this.USkladiste = USkladiste;
    }

    public void setUnSkladiste(String unSkladiste) {
        this.unSkladiste = unSkladiste;
    }
    
    
    
}
