package db;

import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class FXMLController implements Initializable{
  @FXML
  public TextField t1;
  @FXML
  public TextField t2;
  @FXML
  public TextField t3;
  @FXML
  public TextField t4;
  @FXML
  public TextField t5;

  public Statement st;

  @FXML
  public void btnADD(ActionEvent e){
    Book book = new Book();
    try{
      Integer.valueOf(t1.getText());
    }catch(NumberFormatException exception){
      Alert alert = new Alert(AlertType.ERROR);
      alert.setContentText("BookID must be an integer");
      alert.showAndWait();
      return;
    }
    try{
      Double.valueOf(t5.getText());
    }catch(NumberFormatException exception){
      Alert alert = new Alert(AlertType.ERROR);
      alert.setContentText("Price must be an integer");
      alert.showAndWait();
      return;
    }
    book.setId(t1.getText());
    book.setName(t2.getText());
    book.setAuthor(t3.getText());
    book.setPublisher(t4.getText());
    book.setPrice(t5.getText());

    if(table != null){
      table.getItems().add(book);
      if(stage != null){
        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();
        t5.clear();
        stage.close();
      }
    }

  }

  @FXML
  public void btnCANCEL(ActionEvent e){
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setContentText("Close Window, Are you sure?");
    alert.showAndWait();
    ButtonType result = alert.getResult();
    if(result == ButtonType.OK){
      if(stage != null){
        stage.close();
      }
    }
    //System.exit(0);
  }

  @Override
  public void initialize(URL url, ResourceBundle rb){

  }

  private Stage stage;
  public void setStage(Stage stage){
    this.stage = stage;
  }

  private TableView<Book> table;
  public void setTable(TableView<Book> table){
    this.table = table;
  }
}