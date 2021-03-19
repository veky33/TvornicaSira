package tvornicaSira.tableData;


public class SirData {

    public String naziv;
    public String vrsta;
    public float cijena;
    public int godinaProizvodnje;
    public float stanje;
    public int idsira;
    
    public String getNaziv() {
        return naziv;
    }

    public String getVrsta() {
        return vrsta;
    }


    public float getCijena() {
        return cijena;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public float getStanje() {
        return stanje;
    }

    public int getIDsira() {
        return idsira;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }


    public void setCijena(float cijena) {
        this.cijena = cijena;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public void setStanje(float stanje) {
        this.stanje = stanje;
    }

    public void setIDSira(int idsira) {
        this.idsira = idsira;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SirData other = (SirData) obj;
        return this.idsira == other.idsira;
    }

}
