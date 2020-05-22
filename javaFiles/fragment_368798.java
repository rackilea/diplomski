public class SimpleGUI implements ActionListener {

JButton button;

public static void main(String[] args) {

    SimpleGUI gui = new SimpleGUI();
    gui.go();

}

private void go() {
    //Create a JFrame and add title
    JFrame frame = new JFrame();
    frame.setTitle("Basic GUI");
    //Create a button with text and add an ActionListener
    button = new JButton("CLICK ME");
    button.addActionListener(this);
    //Add the button to the content pane
    frame.getContentPane().add(button);
    //Set JFrame properties
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent arg0) {
    button.setText("Button Pressed");
}
}