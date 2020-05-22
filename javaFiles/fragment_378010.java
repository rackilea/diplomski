public static void main(String[] args) {
  // Initialize the frame
  JFrame myApp = new JFrame("App");
  myApp.setSize(1400, 1050);

  // Create container for the GUI
  JPanel container = new JPanel(new BorderLayout());
  container.setPreferredSize(new Dimension(1024, 768));

  // Load the GUI into the container
  JComponent myGui = new JPanel(); // Replace this with actual GUI.
  myGui.setBackground(Color.RED); // Remove this once using actual GUI.
  container.add(myGui, BorderLayout.CENTER);

  // Create the frame's content pane
  JPanel content = new JPanel(new FlowLayout(FlowLayout.CENTER));
  content.setBackground(Color.BLUE); // Also remove this in production.

  // Add GUI to content pane
  content.add(container);

  // Add content pane to frame, show frame
  myApp.setContentPane(content);
  myApp.setVisible(true);
}