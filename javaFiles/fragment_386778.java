for(int i = 0; i < 4; i++) {
    final HBox answer = new HBox();
    hBox[i] = answer;
    Button deleteButton = new Button("X");
    deleteButton.setOnAction(e -> {
       removeAnswer(answer);
    });

    ...
}