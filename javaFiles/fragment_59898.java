public void actionPerformed(ActionEvent e)
{
    String sub = JOptionPane.showInputDialog("Input The Date");
    System.out.println(sub + " TEST");
    label.setText(sub + "SETTED");
}