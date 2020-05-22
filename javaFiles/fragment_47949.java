class Calculator {

  private JButton subtraction;

  public static void main(String[] args) {
    // your code

    // button example
    subtraction = new JButton("-");
    subtraction.addActionListener(new Listener());

    // your code
  }

  class Listener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == nameOfJButton) {
        // do the action for this button
      } else if (e.getSource() == nameOfAnotherButton) {
        // you get the idea
      }
    }

  }

}