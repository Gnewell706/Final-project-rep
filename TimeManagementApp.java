/**
 * Main entry point for the Time Management JavaFX application.
 * 
 * This class launches the application and loads the initial user interface
 * from Scene1.fxml. It sets up the primary stage and displays the main menu.
 * 
 * Responsibilities:
 * - Start the JavaFX application
 * - Load the initial FXML scene (Scene1)
 * - Initialize and display the main application window
 * 
 * This class acts as the entry point of the program and is not part of
 * the MVC structure, but it initializes the View layer.
 * 
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class TimeManagementApp extends Application

{

   public void start(Stage stage) throws IOException
   
   {
   
      Database.initialize();
      Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
      Scene scene = new Scene(root);
      stage.setScene(scene);   
      stage.setTitle("Time Management App");  
      stage.show();
   
   }

}
