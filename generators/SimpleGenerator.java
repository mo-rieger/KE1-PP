/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke1_rieger_moritz_fx.generators;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ke1_rieger_moritz_fx.MainViewController;

/**
 *
 * @author Moritz Rieger
 */
public class SimpleGenerator{
    
    private MainViewController mainController;
    private SimpleGeneratorController sgc;
    private Stage stage;
    
    public SimpleGenerator(MainViewController mc) {
        //create new window for generator
        stage = new Stage();
        stage.setTitle("Simple Generator");
        
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("SimpleGeneratorView.fxml").openStream());
            sgc = (SimpleGeneratorController) fxmlLoader.getController();
            //connect generator to main
            sgc.setMainController(mc);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SimpleGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void show(){
        stage.show();
    }
}
