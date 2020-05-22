public class MyTextArea extends JTextArea {

    private Image img;

    public MyTextArea(int a, int b) {
        super(a,b);
        try{
            img = ImageIO.read(new File("background.jpg"));
        } catch(IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img,0,0,null);
        super.paintComponent(g);
    }
}