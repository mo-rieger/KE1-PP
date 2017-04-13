/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke1_rieger_moritz_fx.generators;

import static java.lang.Integer.parseInt;
import ke1_rieger_moritz_fx.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author peterorlowsky
 */
public class SimpleGeneratorController implements Initializable {
    
    private MainViewController mainController;
    private int index;
    
   @FXML
   private TextField height;
      
   @FXML
   private TextField width;
   
   @FXML
   private Text numericWarning;
   
   @FXML
   private Text state;
     
  /**
   * Handle action related to "Save Image" menu item.
   * 
   * @param event Event on "Save Image" menu item.
   */
    
  @FXML
  private void handleSaveImageAction(final ActionEvent event)
  {
     System.out.println("save Image");
     
     mainController.autoSave(index, "simple-Generator");
     index++;
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
      String h = height.getText();
      String w = width.getText();
      // Form Validation
      // RegEx that matches only integer and decimal numbers
     if(h.matches("(?:\\d*\\.)?\\d+") && w.matches("(?:\\d*\\.)?\\d+")){
        state.setText("berechne");
        numericWarning.setVisible(false);
        mainController.resizeCanvas( parseInt(h), parseInt(w));
        GraphicsContext gc = mainController.getGraphicsContext();
        gc.clearRect(0, 0,  parseInt(w), parseInt(h));
        gc.setFill(Color.BLUE);
        gc.fillOval(parseInt(w)/2, parseInt(h)/2, 50, 50);
        state.setText("fertig");
     } else{
         numericWarning.setVisible(true);
     }

     
  }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        state.setText("bereit");
    }    
    
    public void init(MainViewController main){
        mainController = main;
        index = 0;
    }
    
    
}
