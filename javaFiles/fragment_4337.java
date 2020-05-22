ListSelection<String> selection = new ListSelection<>();
Label label = new Label();
List<String> weekDays = Arrays.asList("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday");

selection.getItems().addAll(weekDays);
label.textProperty().bind(selection.selectedItemProperty());