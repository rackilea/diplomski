class ColorListener implements ActionListener{
    MyDrawPanel colorPanel;
    public ColorListener(MyDrawPanel panel){
        this.colorPanel = panel;
    }

    public void actionPerformed(ActionEvent event2) {
        colorPanel.generateRandomColor();
        frame.repaint();
    }
}

public class MyDrawPanel extends JPanel{
    GradientPaint gradient;
    public MyDrawPanel(){ 
        generateRandomColor();
    }
    public void generateRandomColor(){
        int red = (int)(Math.random()*255);
        int blue = (int)(Math.random()*255);
        int green = (int)(Math.random()*255);
        Color startColor = new Color(red,blue,green);

        red = (int)(Math.random()*255);
        blue = (int)(Math.random()*255);
        green = (int)(Math.random()*255);
        Color endColor = new Color(red,blue,green);

        int startPositionX = (int)(Math.random()*70);
        int startPositionY = (int)(Math.random()*70);

        int endPositionX = (int)(Math.random()*150);
        int endPositionY = (int)(Math.random()*150);

        gradient = new GradientPaint(startPositionX,startPositionY,
            startColor, endPositionX,endPositionY,endColor);
     }
 }