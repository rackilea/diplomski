public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();

            //Create your menu
            final Menu menu1 = new Menu("File");
            final Menu menu2 = new Menu("Options");
            final Menu menu3 = new Menu("Help");
            MenuBar menuBar = new MenuBar();
            menuBar.getMenus().addAll(menu1, menu2, menu3);

            //Your GridPane
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));
            Text scenetitle = new Text("Welcome");
            grid.add(scenetitle, 0, 0, 1, 1);

            //Add them  to root (BorderPane)
            root.setTop(menuBar);
            root.setCenter(grid);


            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
}