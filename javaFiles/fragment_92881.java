package db;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author pc
 */
public class FXMLDocumentController implements Initializable{

  public Statement st;
  @FXML
  public TableView<Book> table;
  //public ObservableList<ObservableList> data;
  private ObservableList<Book> bookData;
  //private Button btnNew = new Button("New Record");

  public void buildData(){
    //data = FXCollections.observableArrayList();
    bookData = FXCollections.observableArrayList();

    try{
      Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
      Connection con = DriverManager.getConnection("jdbc:ucanaccess://D:\\GUI\\Library.accdb", "", "");
      System.out.println("connected...");
      st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      // SQL FOR SELECTING ALL OF BOOK
      String SQL = "SELECT * from BookDB";
      // ResultSet
      ResultSet rs = con.createStatement().executeQuery(SQL);
      /**********************************
       * TABLE COLUMN ADDED DYNAMICALLY *
       **********************************/
      for(int i = 0; i < rs.getMetaData().getColumnCount(); i++){
        // We are using non property style for making dynamic table
        String columnName = rs.getMetaData().getColumnName(i + 1);
        TableColumn<Book, String> col = new TableColumn<>(columnName);
        col.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>(){
          public ObservableValue<String> call(CellDataFeatures<Book, String> param){
            Book book = param.getValue();
            String cellData = book.getValue(columnName);
            return new SimpleStringProperty(cellData);
          }
        });
        table.getColumns().add(col);
        System.out.println("Column [" + i + "] ");
      }

      TableColumn<Book, Boolean> col_action = new TableColumn<>("Action");
      col_action.setSortable(false);
      col_action.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Book, Boolean>, ObservableValue<Boolean>>(){
        @Override
        public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Book, Boolean> p){
          return new SimpleBooleanProperty(p.getValue() != null);
        }
      });
      col_action.setCellFactory(new Callback<TableColumn<Book, Boolean>, TableCell<Book, Boolean>>(){
        @Override
        public TableCell<Book, Boolean> call(TableColumn<Book, Boolean> p){
          return new ButtonCell(table);
        }
      });
      table.getColumns().add(col_action);

      TableColumn<Book, Boolean> col_Delete = new TableColumn<>("Delete");
      col_Delete.setSortable(false);
      col_Delete.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Book, Boolean>, ObservableValue<Boolean>>(){
        @Override
        public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Book, Boolean> p){
          return new SimpleBooleanProperty(p.getValue() != null);
        }
      });
      col_Delete.setCellFactory(new Callback<TableColumn<Book, Boolean>, TableCell<Book, Boolean>>(){
        @Override
        public TableCell<Book, Boolean> call(TableColumn<Book, Boolean> p){
          return new ButtonDelete(table);
        }
      });
      table.getColumns().add(col_Delete);

      /********************************
       * Data added to ObservableList *
       ********************************/
      while(rs.next()){
        Book book = new Book();
        // Iterate Row
        for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
          // Iterate Column
          String columnName = rs.getMetaData().getColumnName(i);
          String columnData = rs.getString(i);
          book.setValue(columnName, columnData);
        }
        System.out.println("Row [1] added " + book.getName());
        bookData.add(book);
      }
      // FINALLY ADDED TO TableView
      table.setItems(bookData);

    }catch(Exception e){
      e.printStackTrace();
      System.out.println("Error on Building Data");
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb){
    buildData();
    table.refresh();
  }

  // Define the button cell
  private class ButtonCell extends TableCell<Book, Boolean>{
    final Button cellButton = new Button("Add");
    ButtonCell(final TableView<Book> tblView) {
      cellButton.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t){
          try{
            //Second s = new Second();
            //s.start(new Stage());
            openFXMLController();
          }catch(Exception ex){
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      });
    }
    // Display button if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty){
      super.updateItem(t, empty);
      if(!empty){
        setGraphic(cellButton);
      }else{
        setGraphic(null);
        setText("");
      }
    }
  }

  private Stage fxmlControllerStage;
  private void openFXMLController(){
    if(fxmlControllerStage == null){
      FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
      try{
        Parent root = loader.load();
        fxmlControllerStage = new Stage();
        fxmlControllerStage.setScene(new Scene(root));
        if(loader.getController() instanceof FXMLController){
          FXMLController fxmlController = loader.getController();
          fxmlController.setStage(fxmlControllerStage);
          fxmlController.setTable(table);
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
    fxmlControllerStage.show();
  }

  // Define the button cell
  private class ButtonDelete extends TableCell<Book, Boolean>{
    final Button delButton = new Button("Delete");
    ButtonDelete(final TableView<Book> tblView) {
      delButton.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t){
          bookData.remove(getIndex());
        }
      });
    }
    // Display button if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty){
      super.updateItem(t, empty);
      if(!empty){
        setGraphic(delButton);
      }else{
        setGraphic(null);
        setText("");
      }
    }
  }
}