JButton button = new JButton("Choose a file!");
button.addActionListener(new ActionListener()
{ 
  public void actionPerformed(ActionEvent e)
  { 
     JFileChooser fileChooser = new JFileChooser();
     fileChooser.setDialogTitle( "Choose a file" );
     fileChooser.setVisible( true );
     fileChooser.setPreferredSize( new Dimension(100, 100) );
  } 
});