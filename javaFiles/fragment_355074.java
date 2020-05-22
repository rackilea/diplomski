ActionListener myActionListener = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        // TODO: put in code I want to have happen on button selection 
        // One ActionListener can likely be used for all buttons in this 
        // small program.
        // as noted below, it could be as simple as one line saying:
        // repaint();
     }
  };
  JRadioButton aRadioButton = new JRadioButton("Fill Color");
  panel.add(aRadioButton);
  group.add(aRadioButton);
  aRadioButton.addActionListener(myActionListener);

  aRadioButton = new JRadioButton("Remove Fill");
  panel.add(aRadioButton);
  group.add(aRadioButton);
  aRadioButton.addActionListener(myActionListener); // add to each radiobutton object