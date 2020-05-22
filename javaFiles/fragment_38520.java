`@FXML
   private void geografButtonAction(ActionEvent event) {
   try {
       FXMLLoader fxmlQuestLoader = new FXMLLoader(getClass().getResource("FXMLQuestionDocument.fxml"));
       quest = new Question("Geografi", "Vad heter Sveriges huvudstad?", "Stockholm");

       Parent root1 = (Parent) fxmlQuestLoader.load();
       root1.setId("pane");
       this.questControll = fxmlQuestLoader.FXMLQuestionDocumentController>getController();
       questControll.setQuestion(quest.getCategory(), quest.getQuestion(), quest.getAnswear());
       Stage app_stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       Scene root1_scene = new Scene(root1);
       root1_scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
       app_stage.hide();
       app_stage.setScene(root1_scene);
       app_stage.show();

    } catch(Exception e) {
       e.printStackTrace();
  }