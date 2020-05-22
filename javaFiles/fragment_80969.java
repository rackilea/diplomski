class Example {
  private int counter = 0;

  void someMethod() {
    Button rezultat = new Button("Pogledajte Vas rezultat");
      rezultat.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(odgovor1_1.isSelected()) this.Example.poeni++;
...