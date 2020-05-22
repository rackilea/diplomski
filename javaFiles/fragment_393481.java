// set the borders of chatBox
layout.putConstraint(SpringLayout.NORTH, chatBox, 5, SpringLayout.NORTH, container);
layout.putConstraint(SpringLayout.WEST, chatBox, 5, SpringLayout.WEST, container);
layout.putConstraint(SpringLayout.EAST, chatBox, 5, SpringLayout.EAST, container);

// set the borders of messageBox
layout.putConstraint(SpringLayout.NORTH, messageBox, 5, SpringLayout.SOUTH, chatBox);
layout.putConstraint(SpringLayout.WEST, messageBox, 5, SpringLayout.WEST, container);

// set the borders of sendButton
layout.putConstraint(SpringLayout.NORTH, sendButton, 5, SpringLayout.SOUTH, chatBox);
layout.putConstraint(SpringLayout.WEST, sendButton, 5, SpringLayout.EAST, messageBox);

// the most importent part set the borders of container (you need only bottom-right)
layout.putConstraint(SpringLayout.EAST, container, 5, SpringLayout.EAST, sendButton);
layout.putConstraint(SpringLayout.SOUTH, container, 5, SpringLayout.SOUTH, sendButton);