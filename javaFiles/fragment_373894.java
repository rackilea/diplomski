class saveListener implements ActionListener{

JTextField incomeData;

public saveListener(JTextField incomeData) {
    this.incomeData = incomeData;
 }

 @Override
 public void actionPerformed(ActionEvent e) {
 String test = incomeData.getText();
    System.out.println("Input data " + test);
  }
}