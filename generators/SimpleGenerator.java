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

/**
 *
 * @author Moritz Rieger
 */
public final class SimpleGenerator extends Generator{
    
    //implement Singleton Pattern
    private static SimpleGenerator sg = null;
    private SimpleGenerator() {
        Stage stage = new Stage();
        stage.setTitle("Simple Generator");
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("SimpleGeneratorView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            

        } catch (IOException ex) {
            Logger.getLogger(SimpleGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Generator getInstance() {
        if(sg == null)
            sg = new SimpleGenerator();
        return sg;
    }
    
}
