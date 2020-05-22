//import newpackage.NewClass //only if it's not in same package. 

//somwhere in code you need to create the new class
NewClass newClass = new NewClass();

//now a button can call methods in newClass
final Button button = new Button("Butt");
button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                newClass.newMethod();
            }
        });