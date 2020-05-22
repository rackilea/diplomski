public class Draw extends JPanel{
    // Instance field, demonstration, so it won't generate a NPE
    private boolean[] array = new boolean[0];
    @Override
    protected void paintComponent(Graphics g){    
        paintComponent(g);
        g.setColor(Color.black);

        for(int i = 0; i < array.length; i++){
            if (array[i]){
                g.drawLine(i, i, i, i);
            }
        }
    }