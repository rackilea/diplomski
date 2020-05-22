TextField answer = new TextField();
answer.autosize();
this.answer = answer.getText();

// node, columnIndex, rowIndex, columnSpan, rowSpan:
this.grid.add(answer, 0, 1, 2, 1);

Text question = new Text("Hi there ! Press Submit to start! Exit to quit.");
question.setFont(Font.font("Century Gothic", FontWeight.BOLD, 22));
question.setFill(Color.BLACK);
this.grid.add(question, 0, 0, 2, 1);