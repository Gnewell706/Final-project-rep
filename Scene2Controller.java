/**
 * Controller for the schedule input scene (Scene2).
 * 
 * This class handles user input for daily activity hours including
 * sleep, study, work, exercise, and leisure.
 * 
 * Responsibilities:
 * - Read and validate numeric input from text fields
 * - Calculate total hours entered by the user
 * - Ensure the schedule equals exactly 24 hours before proceeding
 * - Display feedback if the schedule is invalid
 * - Reset all input fields when requested
 * - Create a ScheduleModel object from valid user input
 * - Save schedule data to the SQLite database
 * - Load the most recently saved schedule when the scene opens
 * - Pass valid data to Scene3 for analysis
 * 
 * The controller uses helper methods to safely parse user input
 * and prevent application crashes due to invalid number formats.
 * 
 * This class is part of the Controller layer in the MVC design pattern
 * and does not contain business logic beyond input validation.
 * 
 */

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

public class Scene2Controller
{
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
   public void initialize()
   {
      DatabaseManager.init();

      ScheduleModel m = DatabaseManager.loadLatest();

      if (m != null)
      {
         sleepTF.setText(String.valueOf(m.getSleep()));
         studyTF.setText(String.valueOf(m.getStudy()));
         workTF.setText(String.valueOf(m.getWork()));
         excerciseTF.setText(String.valueOf(m.getExercise()));
         lesiureTF.setText(String.valueOf(m.getLeisure()));

         updateTotal();
      }
   }


   @FXML
   void ASbutton(ActionEvent event) throws IOException
   {
      double sleep = parse(sleepTF.getText());
      double study = parse(studyTF.getText());
      double work = parse(workTF.getText());
      double exercise = parse(excerciseTF.getText());
      double leisure = parse(lesiureTF.getText());

      double total = sleep + study + work + exercise + leisure;

      if (Math.abs(total - 24) > 0.01)
      {
         ZeroHours.setText("Reevaluate schedule: must equal 24 hours (" + total + " / 24)");
         return;
      }

      ScheduleModel model =
         new ScheduleModel(sleep, study, work, exercise, leisure);

      DatabaseManager.saveData(model);

      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("Scene3.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);

      Scene3Controller controller = loader.getController();
      controller.setModel(model);

      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
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
      double total = parse(sleepTF.getText())
         + parse(studyTF.getText())
         + parse(workTF.getText())
         + parse(excerciseTF.getText())
         + parse(lesiureTF.getText());

      ZeroHours.setText(total + " / 24");
   }
}

