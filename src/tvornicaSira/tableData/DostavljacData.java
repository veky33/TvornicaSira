package tvornicaSira.tableData;

public class DostavljacData {
    public String jmbg;
    public String ime;
    public String vozilo;

    public String getJmbg() {
        return jmbg;
    }

    public String getIme() {
        return ime;
    }

    public String getVozilo() {
        return vozilo;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setVozilo(String vozilo) {
        this.vozilo = vozilo;
    }

    @Override
    public String toString() {
        return ime+" ("+vozilo+")";
    }
    
    
}
