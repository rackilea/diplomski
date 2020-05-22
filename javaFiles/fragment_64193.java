JRadioButton birdButton = new JRadioButton(birdString);
birdButton.setSelected(true);

JRadioButton catButton = new JRadioButton(catString);

   //Group the radio buttons.
ButtonGroup group = new ButtonGroup();
group.add(birdButton);
group.add(catButton);