public class MyButton extends JButton{

  public final int x, int y;

  public MyButton(String text, int x, int y){
    super(text);

    this.x = x;
    this.y = y;

    addMouseListener(new MouseAdapter(){
      @Override
      public void mousePressed(MouseEvent e){
        System.out.println("The mouse was pressed!");
      }
    });
  }

}