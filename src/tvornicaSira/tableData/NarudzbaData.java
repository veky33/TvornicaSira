package tvornicaSira.tableData;

import java.util.Date;

public class NarudzbaData {

    public int idskladista;
    public int idnarudzbe;
    public String idkupca;
    public String nazivKupca;
    public String tip;
    public String skladiste;
    public Date datumNarudzbe;
    public boolean isporucena;
    public String isporucenaString;
    public float Cijena=0;

    public int getIdskladista() {
        return idskladista;
    }

    public int getIdnarudzbe() {
        return idnarudzbe;
    }

    public String getIDkupca() {
        return idkupca;
    }

    public String getNazivKupca() {
        return nazivKupca;
    }

    public String getTip() {
        return tip;
    }

    public String getSkladiste() {
        return skladiste;
    }

    public Date getDatumNarudzbe() {
        return datumNarudzbe;
    }

    public boolean isIsporucena() {
        return isporucena;
    }

    public String getIsporucenaString() {
        return isporucenaString;
    }

    public float getCijena() {
        return Cijena;
    }

    public void setIdskladista(int idskladista) {
        this.idskladista = idskladista;
    }

    public void setIdnarudzbe(int idnarudzbe) {
        this.idnarudzbe = idnarudzbe;
    }

    public void setIDkupca(String idkupca) {
        this.idkupca = idkupca;
    }

    public void setNazivKupca(String nazivKupca) {
        this.nazivKupca = nazivKupca;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setSkladiste(String skladiste) {
        this.skladiste = skladiste;
    }

    public void setDatumNarudzbe(Date datumNarudzbe) {
        this.datumNarudzbe = datumNarudzbe;
    }

    public void setIsporucena(boolean isporucena) {
        this.isporucena = isporucena;
        if (isporucena == true) {
            isporucenaString = "da";
        } else {
            isporucenaString = "ne";
        }
    }

    public void setCijena(float Cijena) {
        this.Cijena = Cijena;
    }

}
