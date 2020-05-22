JFrame frame = new JFrame("My Frame");
frame.setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
frame.setResizable(false);
frame.setUndecorated(true);
frame.pack(); // Important line!!! 
frame.setVisible(true);
System.out.println("--------> "+getContentPane().getWidth());