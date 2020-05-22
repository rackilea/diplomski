public class BoxInFont {
    String text = "سادگی، قابلیت تبدیل";
    int ox = 50;
    int oy = 50;
    void buildGui(){
        JFrame frame = new JFrame("Boxed In Fonts");

        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;
                g.drawString(text, ox, oy);
                Font f = g.getFont();
                Rectangle2D charBounds = f.getStringBounds(text, g2d.getFontRenderContext());
                GlyphVector gv = f.layoutGlyphVector(g2d.getFontRenderContext(), text.toCharArray(), 0, text.length(), GlyphVector.FLAG_MASK);
                Rectangle2D bounds = gv.getVisualBounds();
                g2d.translate(ox, oy);
                //g2d.drawRect((int)bounds.getX() + ox, (int)bounds.getY() + oy, (int)bounds.getWidth(), (int)bounds.getHeight());
                g2d.draw(bounds);
                g2d.draw(charBounds);
                System.out.println("vis: " + bounds);
                System.out.println("char: "  + charBounds);
            }
        };
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void main(String[] args){

        EventQueue.invokeLater(()->new BoxInFont().buildGui());

    }
}