...

MouseListener ml = new MyMouseListener();

//add mouse listener to panel1 and panel2
//panel1.addMouseListener(ml);
//panel2.addMouseListener(ml);

//alternatively add to pane
//pane.addMouseListener(ml);

frame.getGlassPane().addMouseListener(ml);

frame.pack();
frame.setVisible(true);

frame.getGlassPane().setVisible(true);

...