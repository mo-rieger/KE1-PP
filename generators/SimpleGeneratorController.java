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
 * @author Moritz Rieger
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
     
  /**
   * Handle action related to "Save Image" menu item.
   * 
   * @param event Event on "Save Image" menu item.
   */
    
  @FXML
  private void handleSaveImageAction(final ActionEvent event)
  {   
     mainController.saveImageWithoutDialog(index, "simple-Generator");
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
      // Form Validation
      // RegEx that matches only integer and decimal numbers
     if(height.getText().matches("(?:\\d*\\.)?\\d+") && width.getText().matches("(?:\\d*\\.)?\\d+")){
        int h = parseInt(height.getText());
        int w = parseInt(width.getText());
        numericWarning.setVisible(false);
        mainController.resizeCanvas( h, w);
        mainController.setState("berechne");
        generate(w, h);
        mainController.setState("fertig");
     } else{
         numericWarning.setVisible(true);
     }

     
  }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        index = 0;
    }    
    /**
     * generate image an view it on canvas in main
     * @param w width of the image
     * @param h height of the image
     */
    private void generate(int w, int h){
        GraphicsContext gc = mainController.getGraphicsContext();
        gc.clearRect(0, 0,  w, h);
        gc.setFill(Color.BLUE);
        int x = (w<h)? w : h; 
        gc.fillOval(0, 0, x, x);
    }
    //GETTER AND SETTER
    public void setMainController(MainViewController mc){
        mainController = mc;
    }
}
