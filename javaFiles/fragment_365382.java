TextField tf1 = new TextField();
TextField tf2 = new TextField();

StringConverter<Integer> converter = new IntegerStringConverter();

TextFormatter<Integer> formatter1 = new TextFormatter<>(converter, 0);
TextFormatter<Integer> formatter2 = new TextFormatter<>(converter, 0);

tf1.setTextFormatter(formatter1);
tf2.setTextFormatter(formatter2);

Label sum = new Label();
sum.textProperty().bind(IntegerExpression.integerExpression(formatter1.valueProperty())
        .add(IntegerExpression.integerExpression(formatter2.valueProperty())).asString("Sum: %d"));

VBox root = new VBox(tf1, tf2, sum);