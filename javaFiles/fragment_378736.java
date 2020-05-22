RoomListener roomListener = new RoomListener();
JButton[] addButtons = new JButton[ADD_BUTTON_COUNT];
for (int i = 0; i < addButtons.length; i++) {
   addButtons[i] = new JButton("     Add Bed     "); // make text big
   addButtons[i].addActionListener(roomListener);
   addBedPanel.add(addButtons[i]);
}