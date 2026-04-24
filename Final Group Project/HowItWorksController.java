import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class HowItWorksController {

   @FXML
    private Button startButton2;
    
   @FXML
    void BackHandler(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Scene1.fxml"));
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();

   }

   @FXML
    void StartSimHandler2(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Scene2.fxml"));
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();

   }

}
