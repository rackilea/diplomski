// in your field declarations
List<JButton> buttonList = new ArrayList<JButton>();

// elsewhere in your program
for (int i = 0; i < numberOfButtonsToAdd; i++) { 
  JButton button = new JButton();
  buttonList.add(button);
  somePanel.add(button); 
}