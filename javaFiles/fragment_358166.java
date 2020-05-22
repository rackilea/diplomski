public class Circle extends JComponent {
  //draws a circle
  public void paintComponent(Graphics g) {
   //...
  }
}

public class Basketball extends Circle {
  //draws a basketball
  public void paintComponent(Graphics g) {
   super.paintComponent(g); // this will draw the circle outline of your basketball
   //draw the middle
  }
}