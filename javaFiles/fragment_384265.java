RadioButton radioButton1 = ...
RadioButton radioButton2 = ...

// TODO: add RadioButtons to scene

ToggleGroup toggleGroup = new ToggleGroup();

radioButton1.setToggleGroup(toggleGroup);
radioButton2.setToggleGroup(toggleGroup);

// listen to changes in selected toggle
toggleGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> System.out.println(newVal + " was selected"));