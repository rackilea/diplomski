@Override
public void start(Stage stage) {
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(BUTTON_PADDING));
    grid.setHgap(BUTTON_PADDING);
    grid.setVgap(BUTTON_PADDING);

    for (int r = 0; r < NUM_BUTTON_LINES; r++) {
        for (int c = 0; c < BUTTONS_PER_LINE; c++) {
            int number = NUM_BUTTON_LINES * r + c;
            Button button = new Button(String.valueOf(number));
            grid.add(button, c, r);
        }
    }

    ScrollPane scrollPane = new ScrollPane(grid);

    stage.setScene(new Scene(scrollPane));
    stage.show();
}