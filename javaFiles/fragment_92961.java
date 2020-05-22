TilePane pane = new TilePane(); // or whatever you are putting the questions in...

int numQuestions = ... ;

QuestionController[] controllers = new QuestionController[numQuestions];

for (int questionNumber = 0 ; questionNumber < numQuestions ; questionNumber++) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("path/to/QuestionController.fxml"));
    pane.getChildren().add(loader.load());
    controllers[questionNumber] = loader.getController();
}