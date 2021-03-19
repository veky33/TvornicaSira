/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvornicaSira;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author comner
 */
public class PrijavaController implements Initializable {


    @FXML
    private TextField PoljeKorisnickoIme;

    @FXML
    private PasswordField PoljeLozinka;

    @FXML
    private Button DugmeUlogujSe;

    @FXML
    private Button DugmeIzadji;

    @FXML
    private Label LabelaRezultatPrijave;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        LabelaRezultatPrijave.setVisible(false);
        
        DugmeUlogujSe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                provjeraPrijave(event); 
            }
        });
        DugmeIzadji.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
        });

        DugmeUlogujSe.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    provjeraPrijave(event);
                }
            }
        });
    }

    public void provjeraPrijave(Event event) {
        if (prijava()) {
            System.out.println("Uspjesno logovanje");
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            prikaziGlavniMeni();
        } else {
            System.out.println("Neuspjesno logovanje");
            LabelaRezultatPrijave.setVisible(true);
        }
    }

    public void prikaziGlavniMeni() {
        try {
            Stage tabovi = new Stage();
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("tvornicaSira.fxml"));
            Scene myScene = new Scene(myPane);
            tabovi.setTitle("TVORNICA_SIRA_IZBOR");
            tabovi.setScene(myScene);
            tabovi.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean prijava() {
        boolean info = false;
        Connection konekcija = null;
        String upit = null;
        ResultSet rezultat = null;
        PreparedStatement ps = null;
        try {
            konekcija = ConnectionClass.getConnection();
            upit = "SELECT JMBG FROM tvornicasira.zaposlenik WHERE KorisnickoIme=? and Lozinka=?";
            ps = konekcija.prepareStatement(upit);
            ps.setString(1, PoljeKorisnickoIme.getText());
            ps.setString(2, PoljeLozinka.getText());
            rezultat = ps.executeQuery();
            if (rezultat.next()) {
                tvornicaSira.JMBG = rezultat.getString(1);
                info = true;
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
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return info;
    }  
    
    
}
