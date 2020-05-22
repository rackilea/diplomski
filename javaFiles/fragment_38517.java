YourCustomController controller;
//some code...
try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLQuestionDocument.fxml"));
    controller = loader.<YourCustomController>getController();
    //assume that we create a question here
    Question q = new Question(...);
    controller.setQuestion(q);
}
//further code...