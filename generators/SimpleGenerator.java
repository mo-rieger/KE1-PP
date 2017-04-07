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
public final class SimpleGenerator extends Generator{
    
    private MainViewController mainController;
    private SimpleGeneratorController sgc;
    
    //implement Singleton Pattern
    private static SimpleGenerator sg = null;
    private SimpleGenerator() {
        Stage stage = new Stage();
        stage.setTitle("Simple Generator");
        
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("SimpleGeneratorView.fxml").openStream());
            sgc = (SimpleGeneratorController) fxmlLoader.getController();
            System.out.println(sgc);
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
    
    protected void test(){
        System.out.println("heureka");
    }
    
    public void init(MainViewController aThis) {
        sgc.init(aThis);

    }
}
