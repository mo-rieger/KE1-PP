/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke1_rieger_moritz_fx;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author peterorlowsky
 */
public class Main extends Application {
    
    private final int MAX_WIDTH = 1280;
    private final int MAX_HEIGHT = 960;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("MainView.fxml").openStream());
        MainViewController mc = (MainViewController) fxmlLoader.getController();
        mc.setStage(stage);
        
        Scene scene = new Scene(root, 300, 275);
        
        stage.setTitle("KE1_Moritz_Rieger");
        stage.setMaxHeight(MAX_WIDTH);
        stage.setMaxWidth(MAX_HEIGHT);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            System.exit(0);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
  
}
