/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke1_rieger_moritz_fx;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.MenuBar;
import ke1_rieger_moritz_fx.generators.*;

/**
 *
 * @author peterorlowsky
 */
public class MainViewController implements Initializable {
    
    private Generator simpleGenerator;
       
   @FXML
    public Canvas canvas;
   
    public MainViewController() {
    }
  /**
   * Handle action related to "Save Image" menu item.
   * 
   * @param event Event on "Save Image" menu item.
   */
    
  @FXML
  private void handleSaveImageAction(final ActionEvent event)
  {
     System.out.println("Here we go");
  }
  
    /**
   * Handle action related to "Quit" menu item.
   * 
   * @param event Event on "Quit" menu item.
   */
  @FXML
  private void handleQuitAction(final ActionEvent event)
  {
    System.exit(0);
  }
  
  /**
   * Handle action related to "Simple Generator" menu item.
   * 
   * @param event Event on "Simple Generator" menu item.
   */
  @FXML
  private void handleSimplegeneratorAction(final ActionEvent event)
  {
     this.simpleGenerator = SimpleGenerator.getInstance();
     this.simpleGenerator.init(this);
  }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //ToDO
    }    
    
  
    public void resizeCanvas(int height, int width){
        this.canvas.setHeight(height);
        this.canvas.setWidth(width);
    }
}
