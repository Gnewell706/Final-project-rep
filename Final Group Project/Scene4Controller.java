import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class Scene4Controller {
   
   @FXML
    private Label AOCLabel;

   @FXML
    private Label outcomeLabel;

   @FXML
    private PieChart personalizedPlanChart;

   @FXML
    private Label suggestionLabel;
    
   public void setData(double sleep, double study, double work, double exercise, double leisure) {
   
      double total = sleep + study + work + exercise + leisure;
      ScheduleModel model = new ScheduleModel(sleep, study, work, exercise, leisure);
    
      if (total > 24) {
         outcomeLabel.setText("Invalid Schedule (Over 24 hours)");
      } else if (sleep < 6) {
         outcomeLabel.setText("High Stress Schedule");
      } else {
         outcomeLabel.setText("Balanced Schedule");
      }
      
      ArrayList<String> recommendations = model.getRecommendations();
      ArrayList<String> concerns = model.getConcerns();
      
      if (recommendations.isEmpty())
      {
         suggestionLabel.setText("Your schedule is already optimal!");
      } 
      else 
      {
         suggestionLabel.setText(("\n"+recommendations));
      }
      if (concerns.isEmpty()) 
      {
         AOCLabel.setText("Schedule is fully balanced!");
      } else 
      {
         AOCLabel.setText("" + (""+concerns+", "));
      }  
   
      personalizedPlanChart.getData().clear();
   
      personalizedPlanChart.getData().add(new PieChart.Data("Sleep (Target)", model.getRecSleep()));
      personalizedPlanChart.getData().add(new PieChart.Data("Study (Target)", model.getRecStudy()));
      personalizedPlanChart.getData().add(new PieChart.Data("Exercise (Target)", model.getRecExercise()));
      personalizedPlanChart.getData().add(new PieChart.Data("Work(Target)", model.getRecWork()));
      personalizedPlanChart.getData().add(new PieChart.Data("Leisure(Target)", model.getRecLeisure()));
   }
   
   
}
