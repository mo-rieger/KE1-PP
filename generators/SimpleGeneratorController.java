/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke1_rieger_moritz_fx.generators;

import ke1_rieger_moritz_fx.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;

/**
 *
 * @author peterorlowsky
 */
public class SimpleGeneratorController implements Initializable {
    
   @FXML
   private TextField height;
    
   @FXML
   private TextField width;
     
  /**
   * Handle action related to "Save Image" menu item.
   * 
   * @param event Event on "Save Image" menu item.
   */
    
  @FXML
  private void handleSaveImageAction(final ActionEvent event)
  {
     System.out.println("save Image");
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
  private void handleGenerateAction(final ActionEvent event)
  {
     System.out.println("width" + width.getCharacters());
     //setCanvasSize(getheight(),getwidth());
     //MainViewController.canvas.setHeight(500.0);
  }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
