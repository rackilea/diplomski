public void actionPerformed(ActionEvent e) {
  l5.setText("Name: " + t1.getText());
  l6.setText("Street: " + t2.getText());
  l7.setText("City: " + t3.getText());
  l8.setText("Pin: " + t4.getText());

  System.out.println("l5: " + l5.getBounds());
  System.out.println("l6: " + l6.getBounds());
  System.out.println("l7: " + l7.getBounds());
  System.out.println("l8: " + l8.getBounds());

}