//assuming you are displaying your polygon in a JFrame with a JPanel
public class SomeDrawingFrame extends JPanel{
    SomeDrawingFrame(){
    }

    @Override   //JFrame has this method that must be overwritten in order to 
                  display a rendered drawing.

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Polygon square = new Polygon();

        // these points will draw a square
        square.addPoint((0, 0));    //use this.getWidth() method if you want to 
                                         create based on screen size
        square.addPoint((0, 100));
        square.addPoint((100, 100));
        square.addPoint((100, 0)); 
        int y1Points[] = {0, 0, 100, 100};

        g.draw(polygon);
    }
}