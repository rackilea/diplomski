import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExampleApp extends Application
{

    @Override
    public void start( Stage stage )
    {

        TableView<ItemSet> tableView = initializeTableView();

        VBox grid = new VBox( 20 );
        grid.getChildren().addAll( tableView );

        Scene scene = new Scene( grid, 450, 250 );
        stage.setScene( scene );
        stage.show();
    }


    private TableView<ItemSet> initializeTableView()
    {
        final ObservableList<ItemSet> data = FXCollections.observableArrayList();
        for ( int i = 0; i < 4; i++ )
        {
            data.add( new ItemSet( 1, 2, 3, 4, 5, 6, 7, 8, 9 ) );
        }

        TableColumn<ItemSet, Integer> tcRow1 = new TableColumn<>( "tcRow1" );
        tcRow1.setCellValueFactory(
                new PropertyValueFactory<>( "item1" )
        );

        TableColumn<ItemSet, Integer> tcRow2 = new TableColumn<>( "tcRow2" );
        tcRow2.setCellValueFactory(
                new PropertyValueFactory<>( "item2" )
        );

        TableColumn<ItemSet, Integer> tcRow3 = new TableColumn<>( "tcRow3" );
        tcRow3.setCellValueFactory(
                new PropertyValueFactory<>( "item3" )
        );

        TableColumn<ItemSet, Integer> tcRow4 = new TableColumn<>( "tcRow4" );
        tcRow4.setCellValueFactory(
                new PropertyValueFactory<>( "item4" )
        );

        TableColumn<ItemSet, Integer> tcRow5 = new TableColumn<>( "tcRow5" );
        tcRow5.setCellValueFactory(
                new PropertyValueFactory<>( "item5" )
        );

        TableColumn<ItemSet, Integer> tcRow6 = new TableColumn<>( "tcRow6" );
        tcRow6.setCellValueFactory(
                new PropertyValueFactory<>( "item6" )
        );

        TableColumn<ItemSet, Integer> tcRow7 = new TableColumn<>( "tcRow7" );
        tcRow7.setCellValueFactory(
                new PropertyValueFactory<>( "item7" )
        );

        TableColumn<ItemSet, Integer> tcRow8 = new TableColumn<>( "tcRow8" );
        tcRow8.setCellValueFactory(
                new PropertyValueFactory<>( "item8" )
        );

        TableColumn<ItemSet, Integer> tcRow9 = new TableColumn<>( "tcRow9" );
        tcRow9.setCellValueFactory(
                new PropertyValueFactory<>( "item9" )
        );
        TableView<ItemSet> tableView = new TableView();
        tableView.getColumns().addAll( tcRow1, tcRow2, tcRow3, tcRow4, tcRow5, tcRow6, tcRow7, tcRow8, tcRow9 );
        tableView.getItems().setAll( data );
        tableView.setEditable( true );

        return tableView;
    }


    public static void main( String[] args )
    {
        launch( args );
    }


    public static class ItemSet
    {
        int[] items = new int[9];


        public ItemSet( int... args )
        {
            for ( int i = 0; i < args.length; i++ )
            {
                items[i] = args[i];
            }
        }


        public int getItem1()
        {
            return items[0];
        }


        public int getItem2()
        {
            return items[1];
        }


        public int getItem3()
        {
            return items[2];
        }


        public int getItem4()
        {
            return items[3];
        }


        public int getItem5()
        {
            return items[4];
        }


        public int getItem6()
        {
            return items[5];
        }


        public int getItem7()
        {
            return items[6];
        }


        public int getItem8()
        {
            return items[7];
        }


        public int getItem9()
        {
            return items[8];
        }
    }
}