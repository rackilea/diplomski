public void englishQuestions1(Button btn) throws Exception{
    Stage window; 
    window =(Stage) btn.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Question.fxml"));
    Parent root = loader.load();
    EnglishQuestions controller = (EnglishQuestions) loader.getController();
    Scene scene = new Scene(root,900,600);
    window.setScene(scene);
    controller.questionText.setText("What is your name? ");
    window.show();
}