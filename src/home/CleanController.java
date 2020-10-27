package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.apache.commons.io.FileDeleteStrategy;

import java.io.File;

public class CleanController {

  @FXML private Button closeButton;
  @FXML private Button startButton;
  @FXML private Label notDeletedLabel;
  @FXML private Label deletedLabel;

  public void closeButtonOnAction(ActionEvent event) {
    Stage stage = (Stage) closeButton.getScene().getWindow();
    stage.close();
  }

  public void startButtonOnAction(ActionEvent event) {
    Stage stage = (Stage) startButton.getScene().getWindow();
    stage.close();
    try {
      Parent root = FXMLLoader.load(getClass().getResource("cleaner.fxml"));
      Stage primaryStage = new Stage();
      primaryStage.setTitle("Cleaner | Start");
      primaryStage.setScene(new Scene(root, 815, 548));
      primaryStage.show();
    } catch (Exception exception) {
      exception.printStackTrace();
      exception.getCause();
    }
  }

  public void tempFolderButtonOnAction(ActionEvent event) {
    File file =
        new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\Temp");
    if (file.exists()) {
      int notDeletedFiles = 0;
      int deletedFiles = 0;
      for (File files : file.listFiles()) {
        if (!FileDeleteStrategy.FORCE.deleteQuietly(files)) {
          notDeletedFiles++;
        } else {
          deletedFiles++;
        }
      }
      this.setDeletedLabel(deletedFiles + " Dateien wurden gelöscht", OutputState.SUCCESS);
      this.setNotDeletedLabel(
          notDeletedFiles + " Dateien konnten nicht gelöscht werden", OutputState.WARNING);
    } else {
      this.setNotDeletedLabel("Der Ordner existiert nicht", OutputState.ERROR);
    }
  }

  public void downloadFolderButtonOnAction(ActionEvent event) {
    File file = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Downloads");
    if (file.exists()) {
      int notDeletedFiles = 0;
      int deletedFiles = 0;
      for (File files : file.listFiles()) {
        if (!FileDeleteStrategy.FORCE.deleteQuietly(files)) {
          notDeletedFiles++;
        } else {
          deletedFiles++;
        }
      }
      this.setDeletedLabel(deletedFiles + " Dateien wurden gelöscht", OutputState.SUCCESS);
      this.setNotDeletedLabel(
          notDeletedFiles + " Dateien konnten nicht gelöscht werden", OutputState.WARNING);
    } else {
      this.setNotDeletedLabel("Der Ordner existiert nicht", OutputState.ERROR);
    }
  }

  public void minecraftLogsButtonOnAction(ActionEvent event) {
    File file =
        new File(
            "C:\\Users\\"
                + System.getProperty("user.name")
                + "\\AppData\\Roaming\\.minecraft\\logs");
    if (file.exists()) {
      int notDeletedFiles = 0;
      int deletedFiles = 0;
      for (File files : file.listFiles()) {
        if (!FileDeleteStrategy.FORCE.deleteQuietly(files)) {
          notDeletedFiles++;
        } else {
          deletedFiles++;
        }
      }
      this.setDeletedLabel(deletedFiles + " Dateien wurden gelöscht", OutputState.SUCCESS);
      this.setNotDeletedLabel(
          notDeletedFiles + " Dateien konnten nicht gelöscht werden", OutputState.WARNING);
    } else {
      this.setNotDeletedLabel("Der Ordner existiert nicht", OutputState.ERROR);
    }
  }

  public void setNotDeletedLabel(String output, OutputState outputState) {
    notDeletedLabel.setTextFill(Paint.valueOf(outputState.getColor()));
    notDeletedLabel.setText(output);
  }

  public void setDeletedLabel(String output, OutputState outputState) {
    deletedLabel.setTextFill(Paint.valueOf(outputState.getColor()));
    deletedLabel.setText(output);
  }
}
