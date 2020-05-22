public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (source.getValueIsAdjusting() != true) {
            Color mainColor = new Color(red.getValue(),
                    green.getValue(),
                    blue.getValue());
            color.changeColor(mainColor);
            paint.setPaintColor(mainColor);
            color.repaint();
        }
    }

class PaintPanel2 extends JPanel {

    Image image;
    Graphics2D comp2D;
    int currentX, currentY, oldX, oldY;

    public PaintPanel2() {

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                if (comp2D != null) {
                    comp2D.drawLine(oldX, oldY, currentX, currentY);
                }
                repaint();
                oldX = currentX;
                oldY = currentY;
            }
        });
    }

    public void paintComponent(Graphics comp) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            comp2D = (Graphics2D) image.getGraphics();
            comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            comp2D.setPaint(Color.white);
            comp2D.fillRect(0, 0, getSize().width, getSize().height);
            comp2D.setPaint(Color.blue);
            repaint();
        }
        comp.drawImage(image, 0, 0, null);
    }

    public void setPaintColor(Color color) {
        comp2D.setColor(color);
    }
}