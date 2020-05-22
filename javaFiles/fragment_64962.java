//you can use empty border if you want add some insets to the top
//for example: setBorder(new EmptyBorder(5, 0, 0, 0));

addLabel("<html>Current level <b>" + Game.instance()
                                     .getLevelString() +
     "</b></html>");

JPanel buttonPanel = new JPanel();
buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

buttonPanel.add(Box.createVerticalGlue());

buttonPanel.add(createButton("Easy"));

buttonPanel.add(Box.createVerticalGlue());

//Add all buttons

add(buttonPanel, BorderLayout.CENTER);