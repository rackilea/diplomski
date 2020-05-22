IconImage image = ...;
JLabel background = new JLabel(image);
background.setLayout(...);
// You could set the frames content pane to the label and keep
// working as per normal, adding components to the frame
setContentPane(background);
// or, simply add components to it directly like any other container
background.add(...);