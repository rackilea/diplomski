private static class MyActionListener implements ActionListener
{
  private Model model;

  public MyActionListener( Model model )
  {
     this.model = model;
  }

  @Override
  public void actionPerformed( ActionEvent e )
  {
     JComponent source = (JComponent) e.getSource();
     // source == "view"...
  }
}