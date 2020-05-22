public class ColorTextPane extends JFrame {

    static JTextPane muTextPane = new JTextPane();

    public static void main(String[] args) {

        new ColorTextPane();
    }

    public ColorTextPane() {

///// Code from the question /////
        SimpleAttributeSet aset = new SimpleAttributeSet();

        StyleConstants.setForeground(aset, Color.RED);
        StyleConstants.setFontSize(aset, 14);
        muTextPane.setCharacterAttributes(aset, false);
        try {
            muTextPane.getStyledDocument().insertString(muTextPane.getCaretPosition(), "Hello", aset);
            muTextPane.setCaretPosition(muTextPane.getStyledDocument().getLength());
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }

        StyleConstants.setForeground(aset, Color.GREEN);
        muTextPane.setCharacterAttributes(aset, false);
        try {
            muTextPane.getStyledDocument().insertString(muTextPane.getCaretPosition(), " World", aset);
            muTextPane.setCaretPosition(muTextPane.getStyledDocument().getLength());
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
///// End code from the question /////

        muTextPane.setHighlighter(new MyHighlighter());
        add(muTextPane);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private static class MyHighlighter extends DefaultHighlighter {

        private static List<Interval> ranges = new ArrayList<>();
        private static Map<Interval, Color> rangesColors = new HashMap<>();
        private static LayeredHighlighter.LayerPainter DefaultPainter = new MyDHP(null);

        @Override
        public Object addHighlight(int p0, int p1, HighlightPainter p) throws BadLocationException {

            return super.addHighlight(p0, p1, DefaultPainter);
        }

        @Override
        public void removeHighlight(Object tag) {

            super.removeHighlight(tag);
            ranges.clear();
            rangesColors.clear();
        }

        private static class MyDHP extends DefaultHighlightPainter {

            public MyDHP(Color arg0) {
                super(arg0);
            }

            @Override
            public Shape paintLayer(Graphics g, int offs0, int offs1, Shape bounds, JTextComponent c, View view) {

                Rectangle r;

                if (offs0 == view.getStartOffset() && offs1 == view.getEndOffset()) {
                    // Contained in view, can just use bounds.
                    if (bounds instanceof Rectangle)
                        r = (Rectangle) bounds;
                    else
                        r = bounds.getBounds();
                }
                else {
                    // Should only render part of View.
                    try {
                        // --- determine locations ---
                        Shape shape = view.modelToView(offs0, Position.Bias.Forward,
                                                       offs1,Position.Bias.Backward, bounds);
                        r = (shape instanceof Rectangle) ? (Rectangle)shape : shape.getBounds();
                    } catch (BadLocationException e) {
                        // can't render
                        r = null;
                    }
                }

                if (r != null) {
                    // If we are asked to highlight, we should draw something even
                    // if the model-to-view projection is of zero width (6340106).
                    r.width = Math.max(r.width, 1);

                    // Override simple fillRect
                    Interval newInt = new Interval(offs0, offs1);

                    for (Interval interval : ranges) {
                        if (interval.semiIncludes(newInt)) {
                            g.setColor(rangesColors.get(interval));
                            g.fillRect(r.x, r.y, r.width, r.height);
                            return r;
                        }
                    }

                    ranges.add(newInt);
                    rangesColors.put(newInt, getColor());   
                    g.setColor(rangesColors.get(newInt));
                    g.fillRect(r.x, r.y, r.width, r.height);
                }
                return r;
            }

            @Override
            public Color getColor() {

                return StyleConstants.getForeground(muTextPane.getCharacterAttributes());
            }
        }
    }
}

class Interval {

    int start;
    int end;

    Interval(int p0, int p1) {

        start = Math.min(p0, p1);
        end = Math.max(p0, p1);
    }

    boolean semiIncludes(Interval intv) {

        if (intv.start == this.start || intv.end == this.end)
            return true;
        return false;
    }
}