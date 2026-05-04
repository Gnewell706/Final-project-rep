/**
 * Controller for the main menu (Scene1).
 *
 * This scene serves as the entry point of the application.
 * It allows the user to:
 * - Start the schedule simulation
 * - View an example/demo of the application
 *
 * This class is part of the Controller layer in the MVC design pattern
 * and is responsible only for handling user interactions and scene navigation.
 *
 */
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Scene1Controller {

    @FXML
    private Button exampleButton;

    @FXML
    private Button startButton;

    @FXML
    void ExampleHandler(ActionEvent event) throws IOException
    {
      
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Scene5.fxml"));
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }

    @FXML
    void StartSimHandler(ActionEvent event) throws IOException
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
