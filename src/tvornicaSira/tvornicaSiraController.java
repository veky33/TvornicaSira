package tvornicaSira;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import tvornicaSira.tableData.DostavljacData;
import tvornicaSira.tableData.ImenikData;
import tvornicaSira.tableData.KupacData;
import tvornicaSira.tableData.NarudzbaData;
import tvornicaSira.tableData.SkladisteData;
import tvornicaSira.tableData.StavkaData;
import tvornicaSira.tableData.SirData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class tvornicaSiraController implements Initializable {

    ArrayList<ImenikData> arrayListImenikData = new ArrayList<>();
    ArrayList<ImenikData> arrayListZaposlenikData = new ArrayList<>();
    ArrayList<SkladisteData> arrayListSkladisteData = new ArrayList<>();
    ArrayList<NarudzbaData> arrayListNarudzbaData = new ArrayList<>();
    ArrayList<StavkaData> arrayListStavkaData = new ArrayList<>();
    ArrayList<DostavljacData> arrayListDostavljacData = new ArrayList<>();
    ArrayList<SirData> arrayListSirData = new ArrayList<>();
    ArrayList<SirData> stavkeNarudzbe = new ArrayList<>();
    ArrayList<KupacData> arrayListKupacData = new ArrayList<>();
   
    @FXML
    CheckBox prikaziSveSireveCheckBox;
    @FXML
    TextArea izvjestajTextArea;
    @FXML
    TableView stavkeNarudzbePregledTabela;
    @FXML
    TableColumn stavkeNazivKolona;
    @FXML
    TableColumn stavkeVrstaKolona;
    @FXML
    TableColumn stavkeVelicinaKolona;
    @FXML
    TableColumn stavkeCijenaKolona;
    @FXML
    TableColumn stavkeGodinaKolona;
    @FXML
    TableColumn stavkeKolicinaKolona;
    @FXML
    TableColumn stavkeUkupnoKolona;
    @FXML
    DatePicker datumNarudzba;
    @FXML
    CheckBox checkNeisporucene;
    @FXML
    CheckBox checkIsporucene;
    @FXML
    ChoiceBox narudzbeKupac;
    @FXML
    ChoiceBox narudzbeDostavljac;
    @FXML
    TableColumn narudzbaKupacKolona;
    @FXML
    TableColumn narudzbaTipKolona;
    @FXML
    TableColumn narudzbaSkladisteKolona;
    @FXML
    TableColumn narudzbaDatumKolona;
    @FXML
    TableColumn narudzbaIsporucenaKolona;
    @FXML
    TableColumn narudzbaCijenaKolona;
    @FXML
    TableView narudzbaTabela;
    @FXML
    TextField ukupnoCijena;
    @FXML
    TableView stavkeNarudzbeTabela;
    @FXML
    TextField kolicinaSira;
    @FXML
    TableColumn racunSirNaziv;
    @FXML
    TableColumn racunSirVrsta;
    @FXML
    TableColumn racunSirVelicina;
    @FXML
    TableColumn racunSirCijena;
    @FXML
    TableColumn racunSirGodina;
    @FXML
    TableColumn racunSirKolicina;
    @FXML
    TabPane TVORNICA_SIRA_IZBOR;
    @FXML
    TableColumn skladisteNazivKolonaNarudzba;
    @FXML
    TableColumn skladisteVrstaKolonaNarudzba;
    @FXML
    TableColumn skladisteVelicinaKolonaNarudzba;
    @FXML
    TableColumn skladisteCijenaKolonaNarudzba;
    @FXML
    TableColumn skladisteGodinaKolonaNarudzba;
    @FXML
    TableColumn skladisteStanjeKolonaNarudzba;
    @FXML
    TableView sirTabelaNarudzba;
    @FXML
    Button novaNarudzbaButton;
    @FXML
    ChoiceBox narudzbaKupacOdabir;
    @FXML
    ChoiceBox narudzbaSkladisteOdabir;
    @FXML
    TextField kupacIDkupca;
    @FXML
    TextField kupacIDkupcakolona;
    @FXML
    TextField kupacNaziv;
    @FXML
    TextField kupacTip;
    @FXML
    TextField kupacOpis;
    @FXML
    TextField kupacAdresa;
    @FXML
    TextField kupacTelefon;
    @FXML
    TextField kupacEmailadresa;
    @FXML
    TableColumn kupacNazivKolona;
    @FXML
    TableColumn kupacTipKolona;
    @FXML
    TableColumn kupacOpisKolona;
    @FXML
    TableColumn kupacAdresaKolona;
    @FXML
    TableColumn kupacTelefonKolona;
    @FXML
    TableColumn kupacEmailKolona;
    @FXML
    TableColumn kupacIDkupcaKolona;
    @FXML
    TextField cijenaUnosKolicina;
    @FXML
    TextField mlijekoVrsta;
    @FXML
    TextField mlijekoJedCijena;
    @FXML
    TextField mlijekoJedPremija;
    @FXML
    TextField mlijekoKolicina;
    @FXML
    TextField mlijekoKlasa;
    @FXML
    ChoiceBox prenesiSkladisteChoiceBox;
    @FXML
    ChoiceBox prenesenoUSkladisteChoiceBox;
    @FXML
    TextField premjestiBrojKomada;
    @FXML
    RadioButton stanjeDodajRadio;
    @FXML
    TextField stanjeUnosKolicina;
    @FXML
    TextField poljeNaziv;
    @FXML
    TextField poljeVrsta;
    @FXML
    TextField poljeIDsira;
    @FXML
    TextField poljeCijena;
    @FXML
    TextField poljeGodina;
    @FXML
    TextField poljeStanje;
    @FXML
    TableView mlijekoTabela;
    @FXML
    TableView sirTabela;
    @FXML
    TableView kupacTabela;
    @FXML
    TableColumn mlijekoVrstaKolona;
    @FXML
    TableColumn mlijekoCijenaKolona;
    @FXML
    TableColumn mlijekoPremijaKolona;
    @FXML
    TableColumn mlijekoKolicinaKolona;
    @FXML
    TableColumn mlijekoKlasaKolona;
    @FXML
    TableColumn skladisteNazivKolona;
    @FXML
    TableColumn skladisteID;
    @FXML
    TableColumn skladisteVrstaKolona;
    @FXML
    TableColumn skladisteIDKolona;
    @FXML
    TableColumn skladisteCijenaKolona;
    @FXML
    TableColumn skladisteGodinaKolona;
    @FXML
    TableColumn skladisteStanjeKolona;
    @FXML
    TableColumn imenikImeKolona;
    @FXML
    TableColumn imenikFirmaKolona;
    @FXML
    TableColumn imenikTipKolona;
    @FXML
    TableColumn imenikTelefonKolona;
    @FXML
    TableColumn imenikEmailadresaKolona;
    @FXML
    Button imenikOsvjeziButton;
    @FXML
    TableView imenikTabela;
    @FXML
    Button DugmeDodajKupca;
    @FXML
    Button DugmeBrisiKupca;
    @FXML
    Button DugmeIzmjeniKupca;
    @FXML
    Button dodajSirButton;
    @FXML
    Button brisiSirButton;
    @FXML
    Button dodajUodabranoSkladiste;
    @FXML
    Button OtkaziNarudzbu;
    @FXML
    Button PotvrdiNarudzbu;
    @FXML
    Button premjestiButton;
    @FXML
    Button prikaziPoKupcu;
    @FXML
    Button prikaziPoDatumu;
    @FXML
    Button izvrsiDostavu;
    @FXML
    Button dodajMlijeko;
    @FXML
    Button obrisiMlijeko;
    @FXML
    Button izmijeniMlijeko;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        popuniTabeluMlijeko();
        popuniTabeluKupac();
        popuniTabeluSir();
        osvjeziNarudzbeTab();
        osvjeziOdabireNarudzbe();
        novaNarudzba();
        osvjeziImenik();
        premjestiSir();
                
        
          premjestiButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           premjestiSir();
            }
        });
            prikaziPoKupcu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            prikaziNarudzbePoKupcu();
            }
        });
         izvrsiDostavu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            izvrsiDostavuNarudzbe();
            }
        });
        DugmeDodajKupca.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dodajKupca();
            }
        });
       DugmeBrisiKupca.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
         brisiKupca();
           }
       });
       
       DugmeIzmjeniKupca.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
         izmjeniKupca();
           }
       });
        dodajMlijeko.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dodajMlijeko();
            }
        });       
        
        dodajMlijeko.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dodajMlijeko();
            }
        });        
      obrisiMlijeko.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                obrisiMlijeko();
            }
        });       
      brisiSirButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                brisiSir();
            }
        });       
      
    narudzbeKupac.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            prikaziNarudzbePoKupcu();
            }
        });
    
     narudzbeDostavljac.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            //prikaziNarudzbePoDostavljacu();
            }
        });
     
      PotvrdiNarudzbu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            potvrdiNarudzbu();
            }
        });
     
    OtkaziNarudzbu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            otkaziNarudzbu();
            }
        });
    
    novaNarudzbaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            novaNarudzba();
            }
        });
    
     premjestiButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            premjestiSir();
            }
        });
      imenikOsvjeziButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            osvjeziImenik();
            }
        });
     
    }
    
    void osvjeziImenik() {
        Connection connection = ConnectionClass.getConnection();
        try {

            arrayListImenikData.clear();
           PreparedStatement preparedStatement = connection.prepareStatement("call imenik;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ImenikData imenikStavka = new ImenikData();
                imenikStavka.setIme(resultSet.getString(1));
                imenikStavka.setFirma(resultSet.getString(2));
                imenikStavka.setTipImenik(resultSet.getString(3));
                imenikStavka.setTelefon(resultSet.getString(4));          
                imenikStavka.setEmailadresa(resultSet.getString(5));
                arrayListImenikData.add(imenikStavka);
            }
            ObservableList<ImenikData> list = FXCollections.observableArrayList();
            list.addAll(arrayListImenikData);
            imenikTabela.setItems(list);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    void prikaziNarudzbePoKupcu() {
        Connection connection = ConnectionClass.getConnection();
        try {
            arrayListNarudzbaData.clear();
            PreparedStatement preparedStatement = connection.prepareStatement("call prikazi_narudzbe_po_kupcu(?, ?, ?);");
            KupacData kupac = (KupacData) narudzbeKupac.getValue();
            preparedStatement.setString(1, kupacIDkupca.getText());
            preparedStatement.setBoolean(2, checkIsporucene.isSelected());
            preparedStatement.setBoolean(3, checkNeisporucene.isSelected());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                  NarudzbaData narudzba = new NarudzbaData();
                narudzba.setIDkupca(resultSet.getString(1));
                narudzba.setIdskladista(resultSet.getInt(2));
                narudzba.setIdnarudzbe(resultSet.getInt(3));
                narudzba.setNazivKupca(resultSet.getString(4));
                narudzba.setTip(resultSet.getString(5));
                narudzba.setSkladiste(resultSet.getString(6));
                narudzba.setDatumNarudzbe(resultSet.getDate(7));
                narudzba.setIsporucena(resultSet.getBoolean(8));
                narudzba.setCijena(resultSet.getFloat(9));
                arrayListNarudzbaData.add(narudzba);
            }
            ObservableList<NarudzbaData> list = FXCollections.observableArrayList();
            list.addAll(arrayListNarudzbaData);
            narudzbaTabela.setItems(list);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    void prikaziNarudzbePoDostavljacu() {
        Connection connection = ConnectionClass.getConnection();
        try {
            arrayListNarudzbaData.clear();
            PreparedStatement preparedStatement = connection.prepareStatement("call prikazi_narudzbe_po_dostavljacu(?, ?, ?);");
            KupacData kupac = (KupacData) narudzbeKupac.getValue();
            preparedStatement.setString(1, kupacIDkupca.getText());
            preparedStatement.setBoolean(2, checkIsporucene.isSelected());
            preparedStatement.setBoolean(3, checkNeisporucene.isSelected());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NarudzbaData narudzba = new NarudzbaData();
                narudzba.setIDkupca(resultSet.getString(1));
                narudzba.setIdskladista(resultSet.getInt(2));
                narudzba.setIdnarudzbe(resultSet.getInt(3));
                narudzba.setNazivKupca(resultSet.getString(4));
                narudzba.setTip(resultSet.getString(5));
                narudzba.setSkladiste(resultSet.getString(6));
                narudzba.setDatumNarudzbe(resultSet.getDate(7));
                narudzba.setIsporucena(resultSet.getBoolean(8));
                narudzba.setCijena(resultSet.getFloat(9));
                arrayListNarudzbaData.add(narudzba);
            }
            ObservableList<NarudzbaData> list = FXCollections.observableArrayList();
            list.addAll(arrayListNarudzbaData);
            narudzbaTabela.setItems(list);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    void prikaziStavkeNarudzbe() {
        Connection connection = ConnectionClass.getConnection();
        try {
            arrayListStavkaData.clear();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from stavke_narudzbe_view where stavke_narudzbe_view.idnarudzbe=?;");
            NarudzbaData narudzba = (NarudzbaData) narudzbaTabela.getSelectionModel().getSelectedItem();
            preparedStatement.setInt(1, narudzba.getIdnarudzbe());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                StavkaData stavka = new StavkaData();
                stavka.setNaziv(resultSet.getString(1));
                stavka.setVrsta(resultSet.getString(2));
                stavka.setCijena(resultSet.getFloat(3));
                stavka.setGodinaProizvodnje(resultSet.getInt(4));
                stavka.setStanje(resultSet.getFloat(5));
                stavka.setIDSira(resultSet.getInt(6));
                stavka.setUkupno(resultSet.getFloat(7));
                arrayListStavkaData.add(stavka);
            }
            ObservableList<StavkaData> list = FXCollections.observableArrayList();
            list.addAll(arrayListStavkaData);
            stavkeNarudzbePregledTabela.setItems(list);
            //popuni textArea
            if (narudzba.isIsporucena()) {
                preparedStatement = connection.prepareStatement("call dostava_uplata(?);");
                preparedStatement.setInt(1, narudzba.getIdnarudzbe());
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
                izvjestajTextArea.setText("Dostavljač: " + resultSet.getString(1) + "\n" + "Datum dostave: " + resultSet.getDate(2) + "\n" + "Uplaceno na: " + resultSet.getString(3));
            } else {
                izvjestajTextArea.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void prikaziNarudzbePoDatumu() {
        Connection connection = ConnectionClass.getConnection();
        try {
            arrayListNarudzbaData.clear();
            PreparedStatement preparedStatement = connection.prepareStatement("call prikazi_narudzbe_po_datumu(?, ?, ?);");
            LocalDate localDate = datumNarudzba.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            java.util.Date datum = Date.from(instant);
            preparedStatement.setDate(1, new java.sql.Date(datum.getTime()));
            preparedStatement.setBoolean(2, checkIsporucene.isSelected());
            preparedStatement.setBoolean(3, checkNeisporucene.isSelected());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NarudzbaData narudzba = new NarudzbaData();
                narudzba.setIDkupca(resultSet.getString(1));
                narudzba.setIdskladista(resultSet.getInt(2));
                narudzba.setIdnarudzbe(resultSet.getInt(3));
                narudzba.setNazivKupca(resultSet.getString(4));
                narudzba.setTip(resultSet.getString(5));
                narudzba.setSkladiste(resultSet.getString(6));
                narudzba.setDatumNarudzbe(resultSet.getDate(7));
                narudzba.setIsporucena(resultSet.getBoolean(8));
                narudzba.setCijena(resultSet.getFloat(9));
                arrayListNarudzbaData.add(narudzba);
            }
            ObservableList<NarudzbaData> list = FXCollections.observableArrayList();
            list.addAll(arrayListNarudzbaData);
            narudzbaTabela.setItems(list);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    void izvrsiDostavuNarudzbe() {
        Connection connection = ConnectionClass.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("call izvrsi_dostavu(?, ?);");
            NarudzbaData narudzba = (NarudzbaData) narudzbaTabela.getSelectionModel().getSelectedItem();
            DostavljacData dostavljac = (DostavljacData) narudzbeDostavljac.getValue();
            preparedStatement.setInt(1, narudzba.getIdnarudzbe());
            preparedStatement.setString(2, dostavljac.getJmbg());
            preparedStatement.execute();
            narudzba.setIsporucena(true);
            narudzbaTabela.refresh();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void osvjeziNarudzbeTab() {
        Connection connection = ConnectionClass.getConnection();
        try {
            arrayListKupacData.clear();
            PreparedStatement preparedStatement = connection.prepareStatement("select naziv, tip, idkupca from kupac;");
            ResultSet resultSet = preparedStatement.executeQuery();
            narudzbeKupac.getItems().clear();
            while (resultSet.next()) {
                KupacData kupac = new KupacData();
                kupac.setNaziv(resultSet.getString(1));
                kupac.setTip(resultSet.getString(2));
                kupac.setIDkupca(resultSet.getString(3));
                arrayListKupacData.add(kupac);
            narudzbeKupac.getItems().add(kupac.getNaziv());
            }
            ObservableList<KupacData> list = FXCollections.observableArrayList();
            list.addAll(arrayListKupacData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     void prikaziStanjeSira(TableView tabelaZaPrikaz) {
        SkladisteData odabrano = odabranoSkladiste; 
        //(SkladisteData) choiceBoxSkladiste.getValue();
        Connection connection = ConnectionClass.getConnection();
        try {
            arrayListSirData.clear();
            PreparedStatement preparedStatement = connection.prepareStatement("select ime, vrstasira, cijenapokilogramu, godinaproizvodnje, stanje, velicinapakovanja ,idsira from sir_view where idskladista=?;");
            preparedStatement.setInt(1, odabrano.getIdskladista());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SirData sirStavka = new SirData();
                sirStavka.setNaziv(resultSet.getString(1));
                sirStavka.setVrsta(resultSet.getString(2));
                 sirStavka.setCijena(resultSet.getFloat(3));
                sirStavka.setGodinaProizvodnje(resultSet.getInt(4));               
                sirStavka.setStanje(resultSet.getInt(5));
                sirStavka.setIDSira(resultSet.getInt(6));
                arrayListSirData.add(sirStavka);
            }
            ObservableList<SirData> list = FXCollections.observableArrayList();
            list.addAll(arrayListSirData);
            tabelaZaPrikaz.setItems(list);
            //osvjeziSkladistaZaPrenos();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void podesi() {
        //imenik
        imenikImeKolona.setCellValueFactory(new PropertyValueFactory<>("ime"));
        imenikFirmaKolona.setCellValueFactory(new PropertyValueFactory<>("firma"));
        imenikTipKolona.setCellValueFactory(new PropertyValueFactory<>("tipImenik"));
        imenikTelefonKolona.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        imenikEmailadresaKolona.setCellValueFactory(new PropertyValueFactory<>("emailadresa"));
        //skladiste - prikaz sira
        skladisteNazivKolona.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        skladisteVrstaKolona.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        skladisteIDKolona.setCellValueFactory(new PropertyValueFactory<>("IDsira"));
        skladisteCijenaKolona.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        skladisteGodinaKolona.setCellValueFactory(new PropertyValueFactory<>("godinaProizvodnje"));
        skladisteStanjeKolona.setCellValueFactory(new PropertyValueFactory<>("stanje"));
        //skladiste - narudzba iz skladista
        skladisteNazivKolonaNarudzba.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        skladisteVrstaKolonaNarudzba.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        skladisteVelicinaKolonaNarudzba.setCellValueFactory(new PropertyValueFactory<>("velicina"));
        skladisteCijenaKolonaNarudzba.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        skladisteGodinaKolonaNarudzba.setCellValueFactory(new PropertyValueFactory<>("godinaProizvodnje"));
        skladisteStanjeKolonaNarudzba.setCellValueFactory(new PropertyValueFactory<>("stanje"));
        //kupac
        kupacIDkupcaKolona.setCellValueFactory(new PropertyValueFactory<>("IDkupca"));
        kupacNazivKolona.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        kupacTipKolona.setCellValueFactory(new PropertyValueFactory<>("tip"));
        kupacOpisKolona.setCellValueFactory(new PropertyValueFactory<>("opis"));
        kupacAdresaKolona.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        kupacTelefonKolona.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        kupacEmailKolona.setCellValueFactory(new PropertyValueFactory<>("emailadresa"));
        //stavke narudzbe pri pravljenju
        racunSirNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        racunSirVrsta.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        racunSirVelicina.setCellValueFactory(new PropertyValueFactory<>("velicina"));
        racunSirCijena.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        racunSirGodina.setCellValueFactory(new PropertyValueFactory<>("godinaProizvodnje"));
        racunSirKolicina.setCellValueFactory(new PropertyValueFactory<>("stanje"));
        //pregled narudzbi
        narudzbaKupacKolona.setCellValueFactory(new PropertyValueFactory<>("nazivKupca"));
        narudzbaTipKolona.setCellValueFactory(new PropertyValueFactory<>("tip"));
        narudzbaSkladisteKolona.setCellValueFactory(new PropertyValueFactory<>("skladiste"));
        narudzbaDatumKolona.setCellValueFactory(new PropertyValueFactory<>("datumNarudzbe"));
        narudzbaIsporucenaKolona.setCellValueFactory(new PropertyValueFactory<>("isporucenaString"));
        narudzbaCijenaKolona.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        //stavke narudzbe u pregledu
        stavkeNazivKolona.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        stavkeVrstaKolona.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        stavkeVelicinaKolona.setCellValueFactory(new PropertyValueFactory<>("velicina"));
        stavkeCijenaKolona.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        stavkeGodinaKolona.setCellValueFactory(new PropertyValueFactory<>("godinaProizvodnje"));
        stavkeKolicinaKolona.setCellValueFactory(new PropertyValueFactory<>("stanje"));
        stavkeUkupnoKolona.setCellValueFactory(new PropertyValueFactory<>("ukupno"));
    }
    
    void dodajKupca() {
        try {
            Connection connection = ConnectionClass.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tvornicasira.kupac(`IDkupca`, `Naziv`, `Telefon`, `Adresa`, `EmailAdresa`, `Tip`) VALUES(?, ?, ?, ?, ?, ?);");        
            preparedStatement.setString(2, kupacNaziv.getText());
            preparedStatement.setString(1, kupacOpis.getText());
            preparedStatement.setString(3, kupacTelefon.getText());
            preparedStatement.setString(4, kupacAdresa.getText());
            preparedStatement.setString(5, kupacEmailadresa.getText());
            preparedStatement.setString(6, kupacTip.getText());
            preparedStatement.execute();
            kupacNaziv.setText("");
            kupacTip.setText("");
            kupacOpis.setText("");
            kupacAdresa.setText("");
            kupacTelefon.setText("");
            kupacEmailadresa.setText("");
            popuniTabeluKupac();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void brisiKupca() {
        try {
            Connection connection = ConnectionClass.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from kupac where kupac.idkupca=?;");
            Row red = (Row) kupacTabela.getSelectionModel().getSelectedItem();
            preparedStatement.setString(1, red.getOpis());
            preparedStatement.execute();
            kupacTabela.getItems().clear();
            popuniTabeluKupac();
        } catch (Exception e) {
            System.out.println("Kupac se koristi u drugim tabelama, ne moze se obrisati");
        }
    }

         
    void osvjeziOdabireNarudzbe() {
        Connection connection = ConnectionClass.getConnection();
        try {
            arrayListKupacData.clear();
            PreparedStatement preparedStatement = connection.prepareStatement("select naziv, tip, idkupca from kupac;");
            ResultSet resultSet = preparedStatement.executeQuery();
            narudzbaKupacOdabir.getItems().clear();
            while (resultSet.next()) {
                KupacData kupac = new KupacData();
                kupac.setNaziv(resultSet.getString(1));
                kupac.setTip(resultSet.getString(2));
                kupac.setIDkupca(resultSet.getString(3));
                arrayListKupacData.add(kupac);
            narudzbaKupacOdabir.getItems().add(kupac.getNaziv());
            }
            ObservableList<KupacData> list = FXCollections.observableArrayList();
            list.addAll(arrayListKupacData);
//            VVV
//            arrayListSkladisteData.clear();
//            preparedStatement = connection.prepareStatement("call skladiste_skladistar;");
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                SkladisteData skladisteStavka = new SkladisteData();
//                skladisteStavka.setSkladistar(resultSet.getString(1));
//                skladisteStavka.setSkladiste(resultSet.getString(2));
//                skladisteStavka.setIdskladista(resultSet.getInt(3));
//                arrayListSkladisteData.add(skladisteStavka);
//            }
//            ObservableList<SkladisteData> list2 = FXCollections.observableArrayList();
//            list2.addAll(arrayListSkladisteData);
//            narudzbaSkladisteOdabir.setItems(list2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    void novaNarudzba() {
        if ((KupacData) narudzbaKupacOdabir.getSelectionModel().getSelectedItem() == null || (SkladisteData) narudzbaSkladisteOdabir.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        for (Tab each : TVORNICA_SIRA_IZBOR.getTabs()) {
            if (!each.isSelected()) {
                each.setDisable(true);
            }
        }
        novaNarudzbaButton.setDisable(true);
        narudzbaKupacOdabir.setDisable(true);
        narudzbaSkladisteOdabir.setDisable(true);
        prikaziSveSireveCheckBox.setDisable(true);
        odabranoSkladiste = (SkladisteData) narudzbaSkladisteOdabir.getSelectionModel().getSelectedItem();
        prikaziStanjeSira(sirTabelaNarudzba);
        if (prikaziSveSireveCheckBox.isSelected()) {
            Connection connection = ConnectionClass.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select naziv, vrstasira, cijenapokilogramu, stanje,godinaproizvodnje, 0, sir.idsira "
                        + "from sir left join skladiste_sira on sir.idsira=skladiste_sira.idsira where idskladista<>?;");
                SkladisteData skladiste = (SkladisteData) narudzbaSkladisteOdabir.getValue();
                preparedStatement.setInt(1, skladiste.getIdskladista());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    SirData sirStavka = new SirData();
                    sirStavka.setNaziv(resultSet.getString(1));
                    sirStavka.setVrsta(resultSet.getString(2));
                    sirStavka.setCijena(resultSet.getFloat(3));
                    sirStavka.setGodinaProizvodnje(resultSet.getInt(4));
                    sirStavka.setStanje(resultSet.getInt(5));
                    sirStavka.setIDSira(resultSet.getInt(6));
                    arrayListSirData.add(sirStavka);
                }
                ObservableList<SirData> list = FXCollections.observableArrayList();
                list.addAll(arrayListSirData);
                sirTabelaNarudzba.setItems(list);
               // osvjeziSkladistaZaPrenos();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        ukupnoCijena.setText("0.00");
    }
    
     void potvrdiNarudzbu() {
        narudzbaKupacOdabir.setDisable(true);
        narudzbaSkladisteOdabir.setDisable(true);
        novaNarudzbaButton.setDisable(true);
        prikaziSveSireveCheckBox.setDisable(true);
       //for (Tab each : TVORNICA_SIRA_IZBOR.getTabs()) {
        //   each.setDisable(true);
       //}
        sirTabelaNarudzba.setItems(null);
        stavkeNarudzbeTabela.setItems(null);
        ukupnoCijena.setText(" ");
       // stavkeNarudzbe.clear();
    }


    void otkaziNarudzbu() {
        narudzbaKupacOdabir.setDisable(false);
        narudzbaSkladisteOdabir.setDisable(false);
        novaNarudzbaButton.setDisable(false);
        prikaziSveSireveCheckBox.setDisable(false);
        for (Tab each : TVORNICA_SIRA_IZBOR.getTabs()) {
            each.setDisable(false);
        }
        sirTabelaNarudzba.setItems(null);
        stavkeNarudzbeTabela.setItems(null);
        ukupnoCijena.setText("0.00");
        stavkeNarudzbe.clear();
    }

    
    void dodajStavku() {
        int kolicina = Integer.parseInt(kolicinaSira.getText());
        if (kolicina <= 0) {
            return;
        }
        SirData sir = (SirData) sirTabelaNarudzba.getSelectionModel().getSelectedItem();
        //stavkeNarudzbeTabela.setItems(null);
        ObservableList<SirData> list = FXCollections.observableArrayList();
        int staroStanje = 0;
        for (SirData each : stavkeNarudzbe) {
            if (each.equals(sir)) {
                staroStanje += each.getStanje();
            }
        }
        stavkeNarudzbe.remove(sir);
        kolicina += staroStanje;
        sir.setStanje(kolicina);
        stavkeNarudzbe.add(sir);
        list.addAll(stavkeNarudzbe);
        stavkeNarudzbeTabela.setItems(list);
        stavkeNarudzbeTabela.refresh();
        kolicinaSira.setText("");
        float ukupnoCijenaFloat = Float.parseFloat(ukupnoCijena.getText());
        ukupnoCijenaFloat += sir.getCijena() * sir.getStanje() * kolicina;
        ukupnoCijena.setText(String.format("%.2f", ukupnoCijenaFloat));
    }



    void osvjeziSkladisteOdabir() {
        Connection connection = ConnectionClass.getConnection();
        try {
            arrayListSkladisteData.clear();
            PreparedStatement preparedStatement = connection.prepareStatement("call skladiste_skladistar;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SkladisteData skladisteStavka = new SkladisteData();
                skladisteStavka.setSkladistar(resultSet.getString(1));
                skladisteStavka.setSkladiste(resultSet.getString(2));
                skladisteStavka.setIdskladista(resultSet.getInt(3));
                arrayListSkladisteData.add(skladisteStavka);
            }
            ObservableList<SkladisteData> list = FXCollections.observableArrayList();
            list.addAll(arrayListSkladisteData);
            prenesiSkladisteChoiceBox.setItems(list);

        } catch (SQLException ex) {
        }
    }

    SkladisteData odabranoSkladiste = null;

     void dodajMlijeko() {
        try {
            Connection connection = ConnectionClass.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tvornicasira.mlijeko( `Vrsta_Mlijeka`, `JedCijena`,`JedPremija`, `Kolicina`, `Klasa`) VALUES( ?, ?, ?, ?, ?);");        
            preparedStatement.setString(1, mlijekoVrsta.getText());  
            preparedStatement.setDouble(2, Float.parseFloat(mlijekoJedCijena.getText()));
            preparedStatement.setString(3, mlijekoJedPremija.getText());
            preparedStatement.setDouble(4, Float.parseFloat(mlijekoKolicina.getText()));
            preparedStatement.setInt(5, Integer.parseInt(mlijekoKlasa.getText()));
            preparedStatement.execute();
            mlijekoVrsta.setText("");
            mlijekoJedCijena.setText("");
            mlijekoJedPremija.setText("");
            mlijekoKolicina.setText("");
            mlijekoKlasa.setText("");
            popuniTabeluMlijeko();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
     
      void obrisiMlijeko() {
        try {
            Connection connection = ConnectionClass.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from mlijeko where mlijeko.vrsta=?;");
            RowMlijeko red2 = (RowMlijeko) mlijekoTabela.getSelectionModel().getSelectedItem();
            preparedStatement.setString(1, red2.getVrsta());
            preparedStatement.execute();
            kupacTabela.getItems().clear();
            popuniTabeluMlijeko();
        } catch (Exception e) {
            System.out.println("Mlijeko se koristi u drugim tabelama, ne moze se obrisati");
        }
    }

   /**  void dodajSir() {
        try {
             Connection connection = ConnectionClass.getConnection();
          PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tvornicasira.sir(`VrstaSira`, `Naziv`, `Stanje`, `CijenaPoKilogramu`, `Godina`, `IDSira`) VALUES( ?, ?, ?, ?, ?, ?);");        
           //PreparedStatement preparedStatement = connection.prepareStatement("call dodaj_sir_u_skladiste(?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, poljeNaziv.getText());
            preparedStatement.setString(2, poljeVrsta.getText());
            preparedStatement.setFloat(3, Float.parseFloat(poljeCijena.getText()));
            preparedStatement.setInt(4,  Integer.parseInt(poljeGodina.getText()));
            preparedStatement.setFloat(5, Float.parseFloat(poljeStanje.getText()));
            preparedStatement.setInt(6, Integer.parseInt(poljeIDsira.getText()));
    
            poljeNaziv.setText("");
            poljeVrsta.setText("");
            poljeCijena.setText("");
            poljeGodina.setText("");
            poljeStanje.setText("");
            poljeIDsira.setText("");
            popuniTabeluSir();
            /**noviSir.setNaziv(poljeNaziv.getText());
            noviSir.setVrsta(poljeVrsta.getText());
            noviSir.setCijena(Float.parseFloat(poljeCijena.getText()));
            noviSir.setGodinaProizvodnje(Integer.parseInt(poljeGodina.getText()));
            noviSir.setStanje(Float.parseFloat(poljeStanje.getText()));
            noviSir.setIDSira(Integer.parseInt(poljeIDsira.getText()));
            SkladisteData skladiste = (SkladisteData) (prenesiSkladisteChoiceBox.getValue());
            preparedStatement.setInt(7, skladiste.getIdskladista());
            preparedStatement.executeQuery();
            prikaziStanjeSira(sirTabela);
            sirTabela.refresh();   
        } catch (Exception e) {
            System.err.println("Greska");
            e.printStackTrace();
        }
    }   */
     
     
     
      void dodajSir() {
        try {
            SirData noviSir = new SirData();
            noviSir.setNaziv(poljeNaziv.getText());
            noviSir.setVrsta(poljeVrsta.getText());
            noviSir.setCijena(Float.parseFloat(poljeCijena.getText()));
            noviSir.setGodinaProizvodnje(Integer.parseInt(poljeGodina.getText()));
            noviSir.setStanje(Float.parseFloat(poljeStanje.getText()));
            noviSir.setIDSira(Integer.parseInt(poljeIDsira.getText()));
            poljeNaziv.setText("");
            poljeVrsta.setText("");
            poljeCijena.setText("");
            poljeGodina.setText("");
            poljeStanje.setText("");
            poljeIDsira.setText("");
           Connection connection = ConnectionClass.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("call dodaj_sir_u_skladiste(?, ?, ?, ?, ?, ?,?);");
            preparedStatement.setString(1, noviSir.getNaziv());
            preparedStatement.setString(2, noviSir.getVrsta());
            preparedStatement.setFloat(3, noviSir.getCijena());
            preparedStatement.setInt(5, noviSir.getGodinaProizvodnje());
            preparedStatement.setFloat(4, noviSir.getStanje());
            preparedStatement.setInt(6, noviSir.getIDsira());
            SkladisteData skladiste = (SkladisteData) (prenesiSkladisteChoiceBox.getValue());
            preparedStatement.setInt(7, skladiste.getIdskladista());
            preparedStatement.executeQuery();
            prikaziStanjeSira(sirTabela);
            sirTabela.refresh();
        } catch (Exception e) {
            System.err.println("Greska");
            e.printStackTrace();
        }
    }
                
      void brisiSir() {
        try {
            Connection connection = ConnectionClass.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from sir where idsira=?;");
            RowSir sir = (RowSir) sirTabela.getSelectionModel().getSelectedItem();
            System.out.println(sir.getID());
            preparedStatement.setString(1, sir.getID());
            preparedStatement.execute();
            System.out.println("sir.getID(): " + sir.getID());
            sirTabela.getItems().remove(sirTabela.getSelectionModel().getSelectedIndex());
        } catch (SQLException ex) {
              System.out.println("Sir se koristi u drugim tabelama, ne moze se obrisati");
        }
    }
      
    void izmjeniKupca() {
        Connection conn = null;
        String bp = null;
        PreparedStatement preparedStatement = null;
        try {
            kupacTabela.getSelectionModel().getSelectedCells();
            Connection connection = ConnectionClass.getConnection();
            bp= "UPDATE kupac SET naziv=?, tip=?, adresa=?, telefon=?, email=? WHERE idkupca=?";
            preparedStatement = conn.prepareStatement(bp);
            preparedStatement.setString(3, kupacNaziv.getText());
            preparedStatement.setString(1, kupacNaziv.getText());
            preparedStatement.setString(2, kupacTip.getText());
            preparedStatement.setString(4, kupacAdresa.getText());
            preparedStatement.setString(5, kupacTelefon.getText());
            preparedStatement.setString(3, kupacEmailadresa.getText());
            preparedStatement.executeUpdate(); 
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    void premjestiSir() {
        try {
            int kolicina = Integer.parseInt(premjestiBrojKomada.getText());
            SkladisteData skladiste = (SkladisteData) (prenesiSkladisteChoiceBox.getValue());
            SkladisteData skladisteIz = (SkladisteData) (prenesenoUSkladisteChoiceBox.getValue());
            //SkladisteData skladisteU = (SkladisteData) (choiceBoxSkladiste.getValue());
            SirData sir = (SirData) sirTabela.getSelectionModel().getSelectedItem();
            Connection connection = ConnectionClass.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("call premjesti_sir( ?, ?, ?);");
            preparedStatement.setInt(1, kolicina);
            preparedStatement.setInt(2, skladiste.getIdskladista());
            preparedStatement.setInt(3, skladisteIz.getIdskladista());
         //   preparedStatement.setInt(5, skladisteU.getIdskladista());
            preparedStatement.executeQuery();
            premjestiBrojKomada.setText("");
            sirTabela.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void popuniTabeluKupac() {
        kupacNazivKolona.setCellValueFactory(new PropertyValueFactory<Row, String>("Naziv"));
        kupacTipKolona.setCellValueFactory(new PropertyValueFactory<Row, String>("Tip"));
        kupacOpisKolona.setCellValueFactory(new PropertyValueFactory<Row, String>("Opis"));
        kupacAdresaKolona.setCellValueFactory(new PropertyValueFactory<Row, String>("Adresa"));
        kupacTelefonKolona.setCellValueFactory(new PropertyValueFactory<Row, String>("Telefon"));  
        kupacEmailKolona.setCellValueFactory(new PropertyValueFactory<Row, String>("EmailAdresa"));
     
        kupacTabela.getItems().clear();
        
        Connection konekcija = null;
        String upit = null;
        ResultSet rezultat = null;
        Statement s = null;
        try {
            konekcija = ConnectionClass.getConnection();

            upit = "SELECT * FROM tvornicasira.kupac;";
            s = konekcija.createStatement();
            rezultat = s.executeQuery(upit);

            while (rezultat.next()) {
                
                String naziv = rezultat.getString(1);
                String tip = rezultat.getString(2); 
                String opis = rezultat.getString(3);
                String adresa = rezultat.getString(4);
                String telefon = rezultat.getString(5);
                String emailAdresa = rezultat.getString(6);

                kupacTabela.getItems().add(new Row(naziv, tip, opis, adresa, telefon, emailAdresa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rezultat != null) {
                try {
                    rezultat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Row {
      
        private SimpleStringProperty Naziv;
        private SimpleStringProperty Tip;
        private SimpleStringProperty Opis;
        private SimpleStringProperty Adresa;
        private SimpleStringProperty Telefon;
        private SimpleStringProperty EmailAdresa;

        public Row(String Naziv, String Tip, String Opis, String Adresa, String Telefon, String EmailAdresa) {
            this.Naziv = new SimpleStringProperty(Naziv);
            this.Tip = new SimpleStringProperty(Tip);
            this.Opis = new SimpleStringProperty(Opis);
            this.Adresa = new SimpleStringProperty(Adresa);
            this.Telefon = new SimpleStringProperty(Telefon);
            this.EmailAdresa = new SimpleStringProperty(EmailAdresa);
        }


        public String getNaziv() {
            return Naziv.get();
        }

        public void setNaziv(String Naziv) {
            this.Naziv = new SimpleStringProperty(Naziv);
        }

        public String getTip() {
            return Tip.get();
        }

        public void setTip(String Tip) {
            this.Tip = new SimpleStringProperty(Tip);
        }

        public String getOpis() {
            return Opis.get();
        }

        public void setOpis(String Opis) {
            this.Opis = new SimpleStringProperty(Opis);
        }

        public String getAdresa() {
            return Adresa.get();
        }

        public void setAdresa(String Adresa) {
            this.Adresa = new SimpleStringProperty(Adresa);
        }

        public String getTelefon() {
            return Telefon.get();
        }

        public void setTelefon(String Telefon) {
            this.Telefon = new SimpleStringProperty(Telefon);
        }

        public String getEmailAdresa() {
            return EmailAdresa.get();
        }

        public void setEmailAdresa(String EmailAdresa) {
             this.EmailAdresa = new SimpleStringProperty(EmailAdresa);
        }

    }
    
    public void popuniTabeluSir() {
        skladisteNazivKolona.setCellValueFactory(new PropertyValueFactory<RowSir, String>("Naziv"));
        skladisteVrstaKolona.setCellValueFactory(new PropertyValueFactory<RowSir, String>("Vrsta"));
        skladisteCijenaKolona.setCellValueFactory(new PropertyValueFactory<RowSir, String>("Cijena"));
        skladisteGodinaKolona.setCellValueFactory(new PropertyValueFactory<RowSir, String>("GodinaProizvodnje"));
        skladisteStanjeKolona.setCellValueFactory(new PropertyValueFactory<RowSir, String>("Stanje"));
        skladisteIDKolona.setCellValueFactory(new PropertyValueFactory<RowSir, String>("ID"));
        
        Connection konekcija = null;
        String upit = null;
        ResultSet rezultat = null;
        Statement s = null;
        try {
            konekcija = ConnectionClass.getConnection();

            upit = "SELECT * FROM tvornicasira.sir;";
            s = konekcija.createStatement();
            rezultat = s.executeQuery(upit);

            while (rezultat.next()) {
                
                String vrsta  = rezultat.getString(1);
                String naziv = rezultat.getString(2);
                String velicina = rezultat.getString(3);
                String cijena = rezultat.getString(4);
                String godinaProizvodnje = rezultat.getString(5);
                String ID = rezultat.getString(6);

                sirTabela.getItems().add(new RowSir(naziv, vrsta, cijena, godinaProizvodnje, velicina, ID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rezultat != null) {
                try {
                    rezultat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class RowSir {
        
        private SimpleStringProperty Naziv;
        private SimpleStringProperty Vrsta;
        private SimpleStringProperty Cijena;
        private SimpleStringProperty GodinaProizvodnje;
        private SimpleStringProperty Stanje;
        private SimpleStringProperty ID;

        public RowSir(String Naziv, String Vrsta, String Cijena, String GodinaProizvodnje, String Stanje, String ID) {
            this.Naziv = new SimpleStringProperty(Naziv);
            this.Vrsta = new SimpleStringProperty(Vrsta);
            this.Cijena = new SimpleStringProperty(Cijena);
            this.GodinaProizvodnje = new SimpleStringProperty(GodinaProizvodnje);
            this.Stanje = new SimpleStringProperty(Stanje);
            this.ID = new SimpleStringProperty(ID);
        }


        public String getNaziv() {
            return Naziv.get();
        }

        public void setNaziv(String Naziv) {
            this.Naziv = new SimpleStringProperty(Naziv);
        }

        public String getVrsta() {
            return Vrsta.get();
        }

        public void setVrsta(String Vrsta) {
            this.Vrsta = new SimpleStringProperty(Vrsta);
        }

        public String getCijena() {
            return Cijena.get();
        }

        public void setCijena(String Cijena) {
            this.Cijena = new SimpleStringProperty(Cijena);
        }

        public String getGodinaProizvodnje() {
            return GodinaProizvodnje.get();
        }

        public void setGodinaProizvodnje(String GodinaProizvodnje) {
            this.GodinaProizvodnje= new SimpleStringProperty(GodinaProizvodnje);
        }

        public String getStanje() {
            return Stanje.get();
        }

        public void setStanje(String Stanje) {
            this.Stanje = new SimpleStringProperty(Stanje);
        }

        public String getID() {
            return ID.get();
        }

        public void setID(String ID) {
            this.ID = new SimpleStringProperty(ID);
        }

    }  
public void popuniTabeluMlijeko() {
        mlijekoVrstaKolona.setCellValueFactory(new PropertyValueFactory<RowMlijeko, String>("Vrsta"));
        mlijekoCijenaKolona.setCellValueFactory(new PropertyValueFactory<RowMlijeko, String>("Cijena"));
        mlijekoPremijaKolona.setCellValueFactory(new PropertyValueFactory<RowMlijeko, String>("Premija"));
        mlijekoKolicinaKolona.setCellValueFactory(new PropertyValueFactory<RowMlijeko, String>("Kolicina"));
        mlijekoKlasaKolona.setCellValueFactory(new PropertyValueFactory<RowMlijeko, String>("Klasa"));
        
        Connection konekcija = null;
        String upit = null;
        ResultSet rezultat = null;
        Statement s = null;
        try {
            konekcija = ConnectionClass.getConnection();

            upit = "SELECT * FROM tvornicasira.mlijeko;";
            s = konekcija.createStatement();
            rezultat = s.executeQuery(upit);

            while (rezultat.next()) {
                
                String vrsta  = rezultat.getString(1);
                String cijena = rezultat.getString(2);
                String premija = rezultat.getString(3);
                String kolicina = rezultat.getString(4);
                String klasa = rezultat.getString(5);

                mlijekoTabela.getItems().add(new RowMlijeko(vrsta, cijena, premija, kolicina, klasa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rezultat != null) {
                try {
                    rezultat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class RowMlijeko {
        
        private SimpleStringProperty Vrsta;
        private SimpleStringProperty Cijena;
        private SimpleStringProperty Premija;
        private SimpleStringProperty Kolicina;
        private SimpleStringProperty Klasa;

        public RowMlijeko(String Vrsta, String Cijena, String Premija, String Kolicina, String Klasa) {
            this.Vrsta = new SimpleStringProperty(Vrsta);
            this.Cijena = new SimpleStringProperty(Cijena);
            this.Premija = new SimpleStringProperty(Premija);
            this.Kolicina = new SimpleStringProperty(Kolicina);
            this.Klasa = new SimpleStringProperty(Klasa);
        }


        public String getVrsta() {
            return Vrsta.get();
        }

        public void setVrsta(String Vrsta) {
            this.Vrsta = new SimpleStringProperty(Vrsta);
        }

        public String getCijena() {
            return Cijena.get();
        }

        public void setCijena(String Cijena) {
            this.Cijena = new SimpleStringProperty(Cijena);
        }

        public String getPremija() {
            return Premija.get();
        }

        public void setPremija(String Premija) {
            this.Premija= new SimpleStringProperty(Premija);
        }

        public String getKolicina() {
            return Kolicina.get();
        }

        public void setKolicina(String Kolicina) {
            this.Kolicina = new SimpleStringProperty(Kolicina);
        }

        public String getKlasa() {
            return Klasa.get();
        }

        public void setKlasa(String Klasa) {
            this.Klasa = new SimpleStringProperty(Klasa);
        }

    }  
}

