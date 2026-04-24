import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class Scene2Controller {

   private double parse(String text) 
   {
      try 
      {
         return Double.parseDouble(text);
      } 
      catch (NumberFormatException e) 
      {
         return 0;
      }
   }

   @FXML
    private Button AnalyzeSchedule;

   @FXML
    private Button ResetButton;

   @FXML
    private Label ZeroHours;

   @FXML
    private TextField excerciseTF;

   @FXML
    private TextField lesiureTF;

   @FXML
    private TextField sleepTF;

   @FXML
    private TextField studyTF;

   @FXML
    private TextField workTF;

   @FXML
    void ASbutton(ActionEvent event) throws IOException
   {
      double total = parse(sleepTF.getText())
             + parse(studyTF.getText())
             + parse(workTF.getText())
             + parse(excerciseTF.getText())
             + parse(lesiureTF.getText());
   
      if (total != 24) 
      {
         ZeroHours.setText("Reevaluate schedule: must equal 24 hours (" + total + "/24)");
         return;
      }
      else
      {
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("Scene3.fxml"));
         Parent parent = loader.load();
         Scene scene = new Scene(parent);
         Scene3Controller controller = loader.getController();
         controller.setData(sleepTF.getText(),studyTF.getText(),workTF.getText(),excerciseTF.getText(),lesiureTF.getText());
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(scene);
         window.show();
      }
   }

   @FXML
    void ResetButton(ActionEvent event) 
   {
      sleepTF.clear();
      studyTF.clear();
      workTF.clear();
      excerciseTF.clear();
      lesiureTF.clear();
      ZeroHours.setText("0 / 24");
   
   }
   @FXML
   void updateTotal() 
   {
      double sleep = 0;
      double study = 0; 
      double work = 0; 
      double exercise = 0;
      double leisure = 0;
   
      try 
      {
         sleep = Double.parseDouble(sleepTF.getText());
      } 
      catch (NumberFormatException e) 
      { 
         return;
      }
      try 
      {
         study = Double.parseDouble(studyTF.getText());
      } 
      catch (NumberFormatException e) 
      {
         return;
      }
      try 
      {
         work = Double.parseDouble(workTF.getText());
      } 
      catch (NumberFormatException e) 
      {
         return;
      }
      try 
      {
         exercise = Double.parseDouble(excerciseTF.getText());
      } 
      catch (NumberFormatException e) 
      {
         return;
      }
      try 
      {
         leisure = Double.parseDouble(lesiureTF.getText());
      } 
      catch (Exception e) 
      {
         return;
      }
      double total = sleep + study + work + exercise + leisure;
      if (total == 24) 
      {
         ZeroHours.setText("24 / 24 ✓");
      } 
      else 
      {
         ZeroHours.setText("Reevaluate schedule: not 24 hours (" + total + " / 24)");
      }
   }

}
