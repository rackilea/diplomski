private static class tagListener extends MouseAdapter
 {
  private final JFrame frame;

  public tagListener(JFrame frame) 
  { this.frame = frame; }

  public void mouseClicked(MouseEvent e)
  {
   JLabel text =(JLabel)e.getSource();
   displayImage display = new displayImage(text.getText());
   frame.setVisible(false);
   display.setVisible(true);
  }
 }

 public displayImage(String tag) 
 {
  /* snip */
  labelTag.addMouseListener(new tagListener(this));
 }