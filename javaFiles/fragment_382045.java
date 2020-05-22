Class Whatever {
    String[] filterNames;
    JButton[] filterButtons;

    private JButton filterButtons() {
      //set layout for buttons
      setLayout(new BorderLayout());

      //Array to store description of buttons
      filterNames = {myEdgeDetect.getDescription(), 
                                    myEdgeHighlight.getDescription(),
                                    myFlipHorizontal.getDescription(),
                                    myFlipVeritcal.getDescription(),
                                    myGrayscale.getDescription(),
                                    mySharpen.getDescription(),
                                    mySoften.getDescription()};

      filterButtons = new JButton[filterNames.length];

      //This panel store buttons on north
      final JPanel buttonPanel = new JPanel();

      //Start to print buttons
      for (int i = 0; i < filterNames.length; i++) {
        filterButtons[i] = new JButton(filterNames[i]);
        filterButtons[i].setEnabled(false);
        filterButtons[i].addActionListener(null);
        filterButtons[i].setActionCommand(" " + i);
        buttonPanel.add(filterButtons[i]);

      }
   }

   void enableButtons() {
    for (int i = 0; i < filterButtons.length; i++) {
        filterButtons[i].setEnabled(true);
    }
  }
}