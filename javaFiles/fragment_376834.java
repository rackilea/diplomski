// create a new window to hold the visualization
JFrame frame = new JFrame("prefuse example");
// ensure application exits when window is closed
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(d);
frame.pack();           // layout components in window
frame.setVisible(true); // show the window


vis.run("draw");
vis.run("layout");