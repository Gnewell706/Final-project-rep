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
   
      Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
      Scene scene = new Scene(root);
      stage.setScene(scene);   
      stage.setTitle("Time Management App");  
      stage.show();
   
   }

}
