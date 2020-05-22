public void buttonPressed(){
    JDialog dialog = new JDialog();
    JPanel panel = new JPanel();
    JTextField tf = new JTextField();
    panel.add(tf);
    JButton ok = new JButton("ok");
    panel.add(ok);
    dialog.add(panel);
    dialog.setVisible(true);
    System.out.println("dialog closed. tf=" + tf.getText());
}