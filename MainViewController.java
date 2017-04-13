/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke1_rieger_moritz_fx;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuBar;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javafx.stage.Stage;
import ke1_rieger_moritz_fx.generators.*;

/**
 *
 * @author peterorlowsky
 */
public class MainViewController implements Initializable {
    
    private SimpleGenerator simpleGenerator;
    private Stage primaryStage;
    private int canvasHeight;
    private int canvasWidth;
    private String working_dir;
    
   @FXML
    public Canvas canvas;
   public GraphicsContext gc;
   
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
     saveImage();
    
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
     if(simpleGenerator == null){
        this.simpleGenerator = new SimpleGenerator();
        this.simpleGenerator.init(this);
     }else{
              simpleGenerator.show();
     }
  }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvas.getGraphicsContext2D();
        working_dir = System.getProperty("user.dir")+"/Images";
        File dir = new File(working_dir);
        if(!dir.exists())
            dir.mkdir();

    }    
    
  
    public void resizeCanvas(int height, int width){
        canvasHeight = height;
        canvasWidth = width;
        canvas.setHeight(canvasHeight);
        canvas.setWidth(canvasWidth);
        primaryStage.setWidth(canvasWidth);
        primaryStage.setHeight(canvasHeight);

    }
    public GraphicsContext getGraphicsContext(){
        return gc;
    }

    public void setStage(Stage aThis) {
     primaryStage = aThis;   
    }
    private void saveImage(){
        FileChooser fileChooser = new FileChooser();
                 
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = 
                        new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
                fileChooser.getExtensionFilters().add(extFilter);
               
                //Show save file dialog
                File file = fileChooser.showSaveDialog(primaryStage);
                saveImage2PNG(file);
                 
               
    }
    private void saveImage2PNG(File file){
         if(file != null){
                    try {
                        WritableImage writableImage = new WritableImage(canvasWidth, canvasHeight);
                        canvas.snapshot(null, writableImage);
                        RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                        ImageIO.write(renderedImage, "png", file);
                    } catch (IOException ex) {
                        Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }
    public void autoSave(int index, String name){
        File file = new File(working_dir+"/"+name+index+".png");
        try {
            if(file.createNewFile())
                saveImage2PNG(file);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
