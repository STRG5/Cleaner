package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CleanerController {

  @FXML private Button closeButton;
  @FXML private Button cleanButton;

  public void closeButtonOnAction(ActionEvent event) {
    Stage stage = (Stage) closeButton.getScene().getWindow();
    stage.close();
  }

  public void cleanButtonOnAction(ActionEvent event) {
    Stage stage = (Stage) cleanButton.getScene().getWindow();
    stage.close();
    try {
      Parent root = FXMLLoader.load(getClass().getResource("clean.fxml"));
      Stage primaryStage = new Stage();
      primaryStage.setTitle("Cleaner | Clean");
      primaryStage.setScene(new Scene(root, 815, 548));
      primaryStage.show();
    } catch (Exception exception) {
      exception.printStackTrace();
      exception.getCause();
    }
  }
}
