List<JTextField> textFields = new ArrayList<JTextField>();
int autoX = 0;
int autoY = 0;
for (int i = 0; i< units.numOfUnits(); i++ ){
    c.gridx = (autoX % 5);
    c.gridy = autoY;
    if((autoX % 5) == 4){
        autoY++;
    }
    mainPanel.add(new JLabel(units.getUnit(i)),c);
    JTextField textField = new JTextField();
    mainPanel.add(textField);
    textFields.add(textField);
    autoX++;
}