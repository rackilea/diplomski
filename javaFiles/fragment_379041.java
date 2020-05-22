public class GameLabel {
    private String message;
    private Font font;
    private Color color;

    private int x, y;

    public GameLabel(String message, int x, int y, Color color, Font font) {
        update(message, x, y, color, font);
    }

    public GameLabel(String message, int x, int y) {
        this(message, x, y, Color.BLACK, new Font("Matura MT Script Capitals", Font.ROMAN_BASELINE, 20));
    }

    public GameLabel() {
        this("", 0, 0);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public final void update(String message, int x, int y, Color color, Font font) {
        this.message = message;
        this.x = x;
        this.y = y;
        this.color = color;
        this.font = font;
    }

    public void update(String message, int x, int y) {
        update(message, x, y, color, font);
    }

    public void update(String message) {
        update(message, x, y);
    }

    public void paint(Graphics2D g) {
        g.setFont(font);
        g.setColor(color);
        g.drawString(message, x, y);
    }

    public Font getFont() {
        return font;
    }

    public Color getColor() {
        return color;
    }

    public String getMessage() {
        return message;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}