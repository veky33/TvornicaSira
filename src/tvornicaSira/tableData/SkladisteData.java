package tvornicaSira.tableData;


public class SkladisteData {

    String skladistar;
    String skladiste;
    int idskladista;

    public void setSkladistar(String skladistar) {
        this.skladistar = skladistar;
    }

    public void setSkladiste(String skladiste) {
        this.skladiste = skladiste;
    }

    public void setIdskladista(int idskladista) {
        this.idskladista = idskladista;
    }

    public String getSkladistar() {
        return skladistar;
    }

    public String getSkladiste() {
        return skladiste;
    }

    public int getIdskladista() {
        return idskladista;
    }

    public String toString() {
        return skladiste + " (" +skladistar+")" ;
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
        final SkladisteData other = (SkladisteData) obj;
        if (this.idskladista != other.idskladista) {
            return false;
        }
        return true;
    }

}
