/**
 * Controller for the analysis dashboard (Scene3).
 * 
 * This class receives user input from Scene2 and displays
 * a breakdown of the user's daily schedule.
 * 
 * Responsibilities:
 * - Parse and store schedule data passed from Scene2
 * - Calculate total hours and display usage
 * - Display balance status (overloaded, free time, balanced)
 * - Calculate and display productive hours (study + work)
 * - Determine and display stress level based on sleep
 * - Render a pie chart showing distribution of activities
 * - Navigate to Scene4 for personalized recommendations
 * 
 * This class is part of the Controller layer in the MVC design pattern.
 * It handles UI updates and delegates logic to the model where appropriate.
 * 
*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.chart.PieChart;

public class Scene3Controller
{
   private ScheduleModel model;

   @FXML
   private Label balanceStatusLabel;

   @FXML
   private PieChart dashboardPieChart;

   @FXML
   private Label hoursUsedLabel;

   @FXML
   private Label productivityLabel;

   @FXML
   private Label stressLevelLabel;

   @FXML
   private Button suggestionButton;

   public void setModel(ScheduleModel model)
   {
      this.model = model;
      
   
      hoursUsedLabel.setText(model.getTotal() + " / 24");
      balanceStatusLabel.setText(model.getBalanceStatus());
      productivityLabel.setText("Productive Hours: " + model.getProductiveHours());
      stressLevelLabel.setText("Stress Level: " + model.getStressLevel());
   
      dashboardPieChart.getData().clear();
      dashboardPieChart.getData().add(new PieChart.Data("Sleep", model.getSleep()));
      dashboardPieChart.getData().add(new PieChart.Data("Study", model.getStudy()));
      dashboardPieChart.getData().add(new PieChart.Data("Work", model.getWork()));
      dashboardPieChart.getData().add(new PieChart.Data("Exercise", model.getExercise()));
      dashboardPieChart.getData().add(new PieChart.Data("Leisure", model.getLeisure()));
   }

   public void setData(String sleep, String study, String work, String exercise, String leisure)
   {
      double s = 0, st = 0, w = 0, ex = 0, l = 0;
   
      try { s = Double.parseDouble(sleep); } 
      catch (NumberFormatException e) { s = 0; }
      try { st = Double.parseDouble(study); } 
      catch (NumberFormatException e) { st = 0; }
      try { w = Double.parseDouble(work); } 
      catch (NumberFormatException e) { w = 0; }
      try { ex = Double.parseDouble(exercise); } 
      catch (NumberFormatException e) { ex = 0; }
      try { l = Double.parseDouble(leisure); } 
      catch (NumberFormatException e) { l = 0; }
   
      ScheduleModel m = new ScheduleModel(s, st, w, ex, l);
      setModel(m);
   }

   @FXML
   void SuggestionButtonHandler(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("Scene4.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
   
      Scene4Controller controller = loader.getController();
      controller.setModel(model);
   
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   }
}

