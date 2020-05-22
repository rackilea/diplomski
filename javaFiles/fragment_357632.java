import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example extends JPanel {

    String[] numbers;
    ArrayList<RoundedRectangle> rectangles = new ArrayList<RoundedRectangle>();

    public Example() {
        numbers = new String[] { "12", "3", "5" };
        for (int i = 0; i < numbers.length; i++) {
            RoundedRectangle rr = new RoundedRectangle(100 + i * 100, 100, 50, 50, Color.BLUE, numbers[i],
                    new Font(Font.SANS_SERIF, Font.PLAIN, 25));
            rectangles.add(rr);
        }
        rectangles.get(1).setColor(Color.RED);
        System.out.println(rectangles.get(1).getColor());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < rectangles.size(); i++) {
            rectangles.get(i).draw(g2);
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setContentPane(new Example());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    public class RoundedRectangle {

        int x;
        int y;
        int width;
        int height;
        Color color;
        String text;
        Font font;

        public RoundedRectangle(int x, int y, int width, int height, Color color, String text, Font font) {

            setX(x);
            setY(y);
            setWidth(width);
            setHeight(height);
            setColor(color);
            setText(text);
            setFont(font);

        }

        public void draw(Graphics2D g2) {

            g2.setColor(getColor());
            g2.drawRoundRect(x, y, width, height, 15, 15);

            g2.setColor(Color.BLACK);
            FontMetrics metrics = g2.getFontMetrics(getFont());
            int width = metrics.stringWidth(getText());
            int height = metrics.getHeight() - metrics.getAscent();
            g2.setFont(getFont());
            g2.drawString(getText(), getX() + getWidth() / 2 - width / 2, getY() + getHeight() / 2 + height);

        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Font getFont() {
            return font;
        }

        public void setFont(Font font) {
            this.font = font;
        }

    }

}