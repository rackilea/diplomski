@SuppressWarnings("serial")
class SimonPanel extends JPanel {
    public static final String MY_COLOR = "my color";
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private static final int ARC_ANGLE = 90;
    private Map<MyColor, MyArc> colorPressedMap = new EnumMap<MyColor, MyArc>(MyColor.class);
    private List<MyArc> myArcs = new ArrayList<>();

    public SimonPanel() {
        int i = 0;
        for (MyColor myColor : MyColor.values()) {
            int startAngle = 45 - i * 90;
            Arc2D arc = new Arc2D.Double(0, 0, PREF_W, PREF_H, startAngle, ARC_ANGLE, Arc2D.PIE);
            MyArc myArc = new MyArc(arc, myColor);
            myArcs.add(myArc);
            colorPressedMap.put(myColor, myArc);
            i++;
        }
        addMouseListener(new MyMouse());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    public void setMyColorPressed(MyColor myColor, boolean pressed) {
        colorPressedMap.get(myColor).setSelected(pressed);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (MyColor myColor : MyColor.values()) {
            colorPressedMap.get(myColor).fill(g2);
        }
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            for (MyArc myArc : myArcs) {
                if (myArc.contains(e.getPoint())) {
                    myArc.setSelected(true);
                    firePropertyChange(MY_COLOR, null, myArc.getMyColor());
                    repaint();
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            for (MyArc myArc : myArcs) {
                myArc.setSelected(false);
            }
            repaint();
        }
    }
}