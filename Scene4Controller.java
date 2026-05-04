/**
 * Controller for the recommendations and optimization view (Scene4).
 * 
 * This class displays personalized feedback based on the user's schedule.
 * It analyzes the data provided from Scene3 and generates:
 * - A schedule outcome (balanced, overloaded, or high stress)
 * - Recommendations for improvement
 * - Areas of concern
 * - An optimized schedule visualization using a pie chart
 * 
 * Responsibilities:
 * - Receive schedule data from Scene3
 * - Use ScheduleModel to calculate recommendations and concerns
 * - Display user feedback and suggestions
 * - Show optimized schedule breakdown in a pie chart
 * 
 * This class is part of the Controller layer in the MVC design pattern.
 * It focuses on presentation logic and delegates calculations to the model.
 * 
 * 
 */
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class Scene4Controller
{
    private ScheduleModel model;

    @FXML
    private Label AOCLabel;

    @FXML
    private Label outcomeLabel;

    @FXML
    private PieChart personalizedPlanChart;

    @FXML
    private Label suggestionLabel;

    public void setModel(ScheduleModel model)
    {
        this.model = model;

        outcomeLabel.setText(model.getOutcome());

        ArrayList<String> recommendations = model.getRecommendations();
        ArrayList<String> concerns = model.getConcerns();

        if (recommendations.isEmpty())
        {
            suggestionLabel.setText("Your schedule is already optimal!");
        }
        else
        {
            suggestionLabel.setText(String.join("\n", recommendations));
        }

        if (concerns.isEmpty())
        {
            AOCLabel.setText("Schedule is fully balanced!");
        }
        else
        {
            AOCLabel.setText(String.join("\n", concerns));
        }

        personalizedPlanChart.getData().clear();
        personalizedPlanChart.getData().add(new PieChart.Data("Sleep (Target)", model.getRecSleep()));
        personalizedPlanChart.getData().add(new PieChart.Data("Study (Target)", model.getRecStudy()));
        personalizedPlanChart.getData().add(new PieChart.Data("Work (Target)", model.getRecWork()));
        personalizedPlanChart.getData().add(new PieChart.Data("Exercise (Target)", model.getRecExercise()));
        personalizedPlanChart.getData().add(new PieChart.Data("Leisure (Target)", model.getRecLeisure()));
    }

    public void setData(double sleep, double study, double work, double exercise, double leisure)
    {
        ScheduleModel m = new ScheduleModel(sleep, study, work, exercise, leisure);
        setModel(m);
    }
}

