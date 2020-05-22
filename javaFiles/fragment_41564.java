import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;


public class ComboBoxCellTableExample extends Application
{

    private final TableView<TabVo> table = new TableView<>();
    private final ObservableList<TabVo> data
            = FXCollections.observableArrayList(
                    new TabVo( "2222", "column2", FXCollections.<String>observableArrayList( "111", "2222", "3333" ) ),
                    new TabVo( "bbbb", "column2", FXCollections.<String>observableArrayList( "aaaa", "bbbb", "ccccc" ) ),
                    new TabVo( "6666", "column2", FXCollections.<String>observableArrayList( "444", "5555", "6666" ) ),
                    new TabVo( "7777", "column2", FXCollections.<String>observableArrayList( "7777", "8888", "99999" ) ),
                    new TabVo( "hhhh", "column2", FXCollections.<String>observableArrayList( "hhhh", "jjjj", "kkkkk" ) )
            );


    @Override
    public void start( Stage stage )
    {
        Scene scene = new Scene( new Group() );
        stage.setWidth( 450 );
        stage.setHeight( 550 );

        table.setEditable( true );
        Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>()
        {
            @Override
            public TableCell call( TableColumn p )
            {
                return new ComboBoxCell();
            }
        };

        TableColumn column1Col = new TableColumn( "Column 1" );
        column1Col.setMinWidth( 100 );
        column1Col.setCellValueFactory( new PropertyValueFactory<TabVo, String>( "column1" ) );
        column1Col.setCellFactory( cellFactory );
        column1Col.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<TabVo, String>>()
                {
                    @Override
                    public void handle( TableColumn.CellEditEvent<TabVo, String> t )
                    {
                        (( TabVo ) t.getTableView().getItems().get(
                                t.getTablePosition().getRow() )).setColumn1( t.getNewValue() );
                    }
                }
        );

        TableColumn column2Col = new TableColumn( "Column 2" );
        column2Col.setMinWidth( 100 );
        column2Col.setCellValueFactory( new PropertyValueFactory<TabVo, String>( "column2" ) );
        column2Col.setCellFactory( TextFieldTableCell.forTableColumn() );
        column2Col.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<TabVo, String>>()
                {
                    @Override
                    public void handle( TableColumn.CellEditEvent<TabVo, String> t )
                    {
                        (( TabVo ) t.getTableView().getItems().get(
                                t.getTablePosition().getRow() )).setColumn2( t.getNewValue() );
                    }
                }
        );

        table.setItems( data );
        table.getColumns().addAll( column1Col, column2Col );

        (( Group ) scene.getRoot()).getChildren().add( table );

        stage.setScene( scene );
        stage.show();
    }


    class ComboBoxCell extends TableCell<TabVo, String>
    {

        private ComboBox<String> comboBox;


        public ComboBoxCell()
        {
            comboBox = new ComboBox<>();
        }


        @Override
        public void startEdit()
        {
            if ( !isEmpty() )
            {
                super.startEdit();

                comboBox.setItems( getTableView().getItems().get( getIndex() ).getColumn1List() );
                comboBox.getSelectionModel().select( getItem() );

                comboBox.focusedProperty().addListener( new ChangeListener<Boolean>()
                {
                    @Override
                    public void changed( ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue )
                    {
                        if ( !newValue )
                        {
                            commitEdit( comboBox.getSelectionModel().getSelectedItem() );
                        }
                    }
                } );

                setText( null );
                setGraphic( comboBox );
            }
        }


        @Override
        public void cancelEdit()
        {
            super.cancelEdit();

            setText( ( String ) getItem() );
            setGraphic( null );
        }


        @Override
        public void updateItem( String item, boolean empty )
        {
            super.updateItem( item, empty );

            if ( empty )
            {
                setText( null );
                setGraphic( null );
            }
            else
            {
                if ( isEditing() )
                {
                    setText( null );
                    setGraphic( comboBox );
                }
                else
                {
                    setText( getItem() );
                    setGraphic( null );
                }
            }
        }

    }


    public static void main( String[] args )
    {
        launch( args );
    }


    public static class TabVo
    {

        private String column1;
        private String column2;

        private ObservableList<String> column1List;


        private TabVo( String column1, String column2, ObservableList<String> column1List )
        {
            this.column1 = column1;
            this.column2 = column2;
            this.column1List = column1List;
        }


        public String getColumn1()
        {
            return column1;
        }


        public void setColumn1( String column1 )
        {
            this.column1 = column1;
        }


        public String getColumn2()
        {
            return column2;
        }


        public void setColumn2( String column2 )
        {
            this.column2 = column2;
        }


        public ObservableList<String> getColumn1List()
        {
            return column1List;
        }


        public void setColumn1List( ObservableList<String> column1List )
        {
            this.column1List = column1List;
        }

    }

}