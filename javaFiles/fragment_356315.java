public class Board extends JPanel {

    int[] numbers = {3, 25, 5, 6, 60, 100};
    int index = 0;
    static String num;
    boolean once = true;
    FontMetrics fm;

    Board() {
        setPreferredSize(new Dimension(400, 200));
        setBackground(Color.decode("#ffde00"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if (index < 6) {
            num = numbers[index] + "";
        } else {
            num = "Game Ended.";
            Window.ans.setEditable(false);
        }
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Arial", Font.PLAIN, 50));
        if(once){
            fm = g2.getFontMetrics();
            once = false;
        }
        int x = ((getWidth() - fm.stringWidth(num)) / 2);
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2.drawString(num + "", x, y);
        index++;
    }

}