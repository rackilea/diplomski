public class CustomGlassPane extends JPanel{

    public CustomGlassPane(){
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(10, 100, 2000, 100);
    }
}