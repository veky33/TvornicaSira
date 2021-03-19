package tvornicaSira.tableData;

public class KupacData {
    String IDkupca;
    String naziv;
    String tip;
    String opis;
    String adresa;
    String telefon;
    String EmailAdresa;
    int brojNarudzbi;
    int brojDostava;

    public String getNaziv() {
        return naziv;
    }
    
    public String getIDkupca() {
        return IDkupca;
    }

    public String getTip() {
        return tip;
    }
    
     public String getOpis() {
        return opis;
    }

    public String getAdresa() {
        return adresa;
    }
    
     public String getTelefon() {
        return telefon;
    }

     public String getEmailAdresa() {
        return EmailAdresa;
    }


    public int getBrojNarudzbi() {
        return brojNarudzbi;
    }

    public int getBrojDostava() {
        return brojDostava;
    }


    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
     public void setIDkupca(String IDkupca) {
        this.IDkupca = IDkupca;
    }
     
    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
   
     public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
     
      public void setEmailAdresa(String EmailAdresa) {
        this.EmailAdresa = EmailAdresa;
    }
      
    public void setBrojNarudzbi(int brojNarudzbi) {
        this.brojNarudzbi = brojNarudzbi;
    }

    public void setBrojDostava(int brojDostava) {
        this.brojDostava = brojDostava;
    }

}
