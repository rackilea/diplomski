german.setCellValueFactory(item -> new SimpleStringProperty(item.getValue().getGerman()));
english.setCellValueFactory(item -> new SimpleStringProperty(item.getValue().getEnglish()));

given.setCellValueFactory(item -> item.getValue().givenAnswersProperty());
correct.setCellValueFactory(item -> item.getValue().correctAnswersProperty());
skipped.setCellValueFactory(item -> item.getValue().skippedAnswersProperty());