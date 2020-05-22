class MyClass{
private JLabel myLabel;
private JFrame mainFrame;
private JButton myButton;
MyClass(){
      mainFrame = new JFrame();
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new FlowLayout());
      myLabel= new JLabel("YourText");
      myButton = new JButton("Click");
      MyListener listener = new MyListener(myLabel.getText());
      myButton.addActionListener(listener);
  }

}
class MyListener implements ActionListener{

 private String jobText;
 private Job job;//Not Sure
 MyListener(String text){
    jobText = text;
    job = new Job();//Not Sure
 }
 @Override
 public void actionPerformed(ActionEvent e) {
    job.setJob(jobText);
 }

}