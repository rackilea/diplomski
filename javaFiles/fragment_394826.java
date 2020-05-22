public class MyPanel extends JPanel{

    private Path2D.Double parallelogram;

    public MyPanel(){
        parallelogram = new Path2D.Double();
        parallelogram.moveTo(0,0);
        parallelogram.lineTo(50,0);
        parallelogram.lineTo(100,50);
        parallelogram.lineTo(50,50);
        parallelogram.closePath();

        setPreferredSize(new Dimension(100, 100));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.fill(parallelogram);
    }
}