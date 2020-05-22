JButton addPerson = new JButton("Add");
addPerson.addActionListener(event -> {
    int height = sliderHeight.getValue();
    int weight = sliderWeight.getValue();
    String name = nameField.getText();
    String size = (String) sizes.getSelectedItem();

    if (!name.isEmpty()) {
        model.addPerson(height, weight, name, size);
    }else {
        System.out.println("Enter the name.");
    }
});