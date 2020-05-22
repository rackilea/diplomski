public class AJListenerAdapter implements ActionListener{
  public void actionPerformed(ActionEvent e){
     Base.open(...);
     doPerform(ActionEvent e);
     Base.close(...);
  }

  protected abstract doPerform(ActionEvent e);
}