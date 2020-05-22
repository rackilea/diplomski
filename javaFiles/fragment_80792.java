public class Painter implements Runnable{
  private ArrayList<Widget> widgets;
  public Painter(ArrayList<Widget> widgets) {
      this.widgets = widgets;
  }
  public void run(){
     paintSomeStuffBasedOnContentOf(widgets);
  }
}