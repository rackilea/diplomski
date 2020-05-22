public class Tile extends JLabel {

    public static Font font = new Font("Serif", Font.BOLD, 39);

    private char _c;

    public Tile(char c, Color background) {
        setBackground(background);
        setOpaque(true);
        _c = c;
        setText(convert());

    }

    public static char randomLetter() {
        Random r = new Random();
        char randomChar = (char) (97 + r.nextInt(25));
        return randomChar;
    }

    public char getChar() {
        return _c;
    }

    public String convert() {
        return String.valueOf(getChar());
    }
}