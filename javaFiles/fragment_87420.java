public class Gui extends Application {

    private final static IntBinaryOperator PLUS = new BinaryPlusOperator();

    @Override
    public void start(Stage primaryStage) {
        Calculator calc = new Calculator();

        // display parts of formula in ListView
        ListView<String> formulaPartsDisplay = new ListView<>(calc.getFormulaParts());
        formulaPartsDisplay.setMaxHeight(30);
        formulaPartsDisplay.setOrientation(Orientation.HORIZONTAL);

        Text operand = new Text();
        operand.setFont(Font.font(20));

        // display current input in Text
        operand.textProperty().bind(calc.operandProperty());

        VBox display = new VBox(5, formulaPartsDisplay, operand);
        display.setAlignment(Pos.CENTER_RIGHT);
        VBox.setVgrow(display, Priority.NEVER);
        display.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        Button plus = new Button("+");
        Button eval = new Button("=");
        Button d1 = new Button("1");

        // event handlers invoke appropriate methods of Calculator
        plus.setOnAction(evt -> calc.addBinaryOperator(PLUS));
        eval.setOnAction(evt -> calc.evaluate());
        d1.setOnAction(evt -> calc.addDigit((byte) 1));

        GridPane buttons = new GridPane();
        buttons.add(d1, 0, 0);
        buttons.addRow(1, plus, eval);

        Scene scene = new Scene(new VBox(display, buttons));

        primaryStage.setScene(scene);
        primaryStage.show();
    }