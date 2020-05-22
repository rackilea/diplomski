@Override
public void start( final Stage primaryStage )
{

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setHgrow( Priority.ALWAYS );

    ColumnConstraints col2 = new ColumnConstraints();
    col2.setHgrow( Priority.ALWAYS );

    GridPane gridPane = new GridPane();
    gridPane.setGridLinesVisible( true );
    gridPane.getColumnConstraints().addAll( new ColumnConstraints( 60 ), col1, new ColumnConstraints( 100 ), col2 );

    gridPane.addColumn( 0, new Button( "col 1" ) );
    gridPane.addColumn( 1, new Button( "col 2" ) );
    gridPane.addColumn( 2, new Button( "col 3" ) );
    gridPane.addColumn( 3, new Button( "col 4" ) );

    final Scene scene = new Scene( new VBox( gridPane ), 400, 300 );
    primaryStage.setScene( scene );
    primaryStage.show();
}