public class Test extends JFrame {
  JTextField text = new JTextField("Press Return", 40);

  public Test() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    text.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { // Called whenever any action preform on textfield
        System.out.println("Text=" + text.getText());
        // Do validation here 
      }
    });

    getContentPane().add(text, "Center");
    pack();
  }

  public static void main(String[] args) {
    new Test().setVisible(true);
  }
}