public class MovingBlockCanvas extends JPanel {

int xValue = 50;
int yValue = 50;
int width = 10;
int height = 10;
String desiredShape;
BufferedImage drawing;

public MovingBlockCanvas(){

}

public void drawShapes(){
    if(drawing == null){
        createBufferedImage();
    }
    if(desiredShape.equals("Rectangle")){
        Graphics2D g = drawing.createGraphics();
        g.setColor(ColorPanel.getColor2());
        g.fillRect(yValue, xValue, width, height);
        g.dispose();
    }
    if(desiredShape.equals("Circle")){
        Graphics2D g = drawing.createGraphics();
        g.setColor(ColorPanel.getColor2());
        g.fillOval(yValue, xValue, width, height);
        g.dispose();
    }
    repaint();
}

public void createBufferedImage() {


        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = buffer.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
        drawing = buffer;

}


@Override
public void paintComponent(Graphics render){

    super.paintComponent(render);
    Graphics2D g = (Graphics2D) render.create();
    if(drawing == null){
        createBufferedImage();
    }
    g.drawImage(drawing, 0, 0, this);
    g.dispose();


}


}