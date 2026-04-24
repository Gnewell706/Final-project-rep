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
import javafx.scene.control.TextField;
import javafx.scene.chart.PieChart;

public class Scene3Controller {
   
   private double sleepH, studyH, workH, exerciseH, leisureH;

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

   @FXML
    void SuggestionButtonHandler(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("Scene4.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Scene4Controller controller = loader.getController();
      controller.setData(sleepH,studyH,workH,exerciseH,leisureH);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   
   }
   public void setData(String sleep, String study, String work, String exercise, String leisure) 
   {    
      try
      { 
         sleepH = Double.parseDouble(sleep); 
      } 
      catch (NumberFormatException e) 
      { 
         sleepH = 0; 
      }
      try 
      { 
         studyH = Double.parseDouble(study); 
      } 
      catch (NumberFormatException e) 
      {
         studyH = 0; 
      }
      try 
      { 
         workH = Double.parseDouble(work); 
      } 
      catch (NumberFormatException e) 
      {
         workH = 0; 
      }
      try 
      {
         exerciseH = Double.parseDouble(exercise); 
      } 
      catch (NumberFormatException e) 
      {
         exerciseH = 0; 
      }
      try 
      {
         leisureH = Double.parseDouble(leisure); 
      } 
      catch (NumberFormatException e) 
      {
         leisureH = 0; 
      }
   
      double total = sleepH + studyH + workH + exerciseH + leisureH;
   
    
      hoursUsedLabel.setText(""+total+" /24");
   
      if (total > 24) {
         balanceStatusLabel.setText("Overloaded");
      } else if (total < 24) {
         balanceStatusLabel.setText("Free Time");
      } else {
         balanceStatusLabel.setText("Perfectly Balanced");
      }
   
      double productive = studyH + workH;
      productivityLabel.setText("Productive Hours: " + productive);
   
      if (sleepH < 6) {
         stressLevelLabel.setText("High Stress");
      } else {
         stressLevelLabel.setText("Normal Stress");
      }
   
    
      dashboardPieChart.getData().clear();
      dashboardPieChart.getData().add(new PieChart.Data("Sleep", sleepH));
      dashboardPieChart.getData().add(new PieChart.Data("Study", studyH));
      dashboardPieChart.getData().add(new PieChart.Data("Work", workH));
      dashboardPieChart.getData().add(new PieChart.Data("Exercise", exerciseH));
      dashboardPieChart.getData().add(new PieChart.Data("Leisure", leisureH));
   }

   
