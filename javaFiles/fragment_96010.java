// Gets the screen resolution
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
// Gets the width and height
double width = screenSize.getWidth();
double height = screenSize.getHeight();
// Subtract height of taskbar from height in my case 50 
frame.setSize((int)width, (int)height - 50);
frame.setLocationRelativeTo(null);  // Set frame at center of the screen
frame.setUndecorated(true); // Removes title bar
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);