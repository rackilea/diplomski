class JTextPaneExample {

    public static void main(String[] args) {
        JTextPane tp = new JTextPane();
        tp.setSize(250, 250);
        appendToPane(tp, "Hello Java,\n\n", Color.BLACK);
        appendToPane(tp, "Hello Suing,\n\n\n\n", Color.BLUE);
        appendToPane(tp, "Hello......,\n", Color.RED);
        JFrame f = new JFrame();

        f.setSize(300, 300);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(tp);
        f.setVisible(true);
    }

    public static void appendToPane(JTextPane tp, String txt, Color clr) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, clr);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Serif");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(txt);
    }
}