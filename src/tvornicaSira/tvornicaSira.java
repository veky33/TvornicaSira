package tvornicaSira;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class tvornicaSira extends Application {
    
    public static String JMBG;

 @Override
    public void start(Stage primaryStage) {
        prikaziPrijavaKorisnika();   //samo prvi prozor
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
     public void prikaziPrijavaKorisnika() {
        try {
            Stage prijavaKorisnikaStage = new Stage();
            Pane Pane = (Pane)FXMLLoader.load(getClass().getResource("Prijava.fxml"));
            Scene Scene = new Scene(Pane);
            prijavaKorisnikaStage.setTitle("Prijava korisnika");
            prijavaKorisnikaStage.setScene(Scene);
            prijavaKorisnikaStage.show();   
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}