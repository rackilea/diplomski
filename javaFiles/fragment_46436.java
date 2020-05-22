final Controller c = new Controller(....) ;
     if(.... ) //manager
{
    if (jRadioButton1.isSelected())
    {
      java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
        MyGUI gui = new MyGUI(c);//pass object c to MyGUI Thread via constructor
        // gui.setController(c); //or you could have a setter method
        gui.setVisible(true);
    }