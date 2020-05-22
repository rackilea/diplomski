public class GUI extends Frame {

    private Font font;
    // Don't use hard coded values, use the constent names, its easier
    // to read
    private int fontStyle = Font.PLAIN;
    private int fontSize = 12;

    public GUI() {
        String fontName = "Arial";
        font = new Font(fontName, fontStyle, fontSize);

        //...
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font.deriveFont(++fontSize);
                textArea.setFont(font);
            }
        });
        //...