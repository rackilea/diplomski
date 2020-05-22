class Drawing extends JPanel {

int mazeSize;

public Drawing(JTextField jtf)
{
    try {
    this.mazeSize = Integer.parseInt(jtf.getText());
    }

    catch (Exception e) 
    {
        JOptionPane.showMessageDialog(this, "ERROR!  Invalid size value!");
    }
} // the constructor gets the size of the drawing from a textField

public Dimension getPreferredSize() {
    return new Dimension(mazeSize*10,mazeSize*10);
} //getPreferredSize - this method is used by the scroll pane to adjust its own size automatically

public void drawMaze (Graphics g) 
{
    /* some irrelevant code that does the desired drawing to the panel by calling g.drawLine()*/

} // drawMaze method that does the de facto drawing

@Override
public void paintComponent(Graphics g) 
{
    super.paintComponent(g);
    drawMaze(g);        
}// paintComponent() @Override method - this was the tricky part

}//Drawing JPanel subclass