public void poundIncrementButtonPressed(ActionEvent event) {
    System.out.println("pound increment button pressed");
    Button button = (Button) event.getSource();
    // identifies which plate is to be incremented
    int plate = poundIncrementButtons.indexOf(button);
    incrementDecrementPlate(0, 0, plate);
}