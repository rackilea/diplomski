aJToggleButton tButton=new aJToggleButton();//contains JTextPane
tButton.getTextPane().addActionListener(this);

public void actionPerformed(ActionEvent e)
{
  ((aJToggleButton )((JTextPane)e.getSource()).getParent()).setSelected(true);
}