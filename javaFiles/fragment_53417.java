/**
 *
 * Custom SliderUI for AudioPlayer with audioimage in background
 */
public class AudioSliderUI extends BasicSliderUI {

    private BasicStroke stroke = new BasicStroke(1f, BasicStroke.CAP_ROUND, 
            BasicStroke.JOIN_ROUND, 0f);

    public AudioSliderUI(AudioSlider b) {
        super(b);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        super.paint(g, c);
    }

    @Override
    protected Dimension getThumbSize() {
        return new Dimension(2, 200);
    }

    @Override
    public void paintTrack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke old = g2d.getStroke();
        g2d.setStroke(stroke);
        g2d.setPaint(Color.WHITE);
        if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
            g2d.drawLine(trackRect.x, trackRect.y + trackRect.height / 2, 
                    trackRect.x + trackRect.width, trackRect.y + trackRect.height / 2);
        } else {
            g2d.drawLine(trackRect.x + trackRect.width / 2, trackRect.y, 
                    trackRect.x + trackRect.width / 2, trackRect.y + trackRect.height);
        }
        g2d.setStroke(old);
        Image img = ((AudioSlider)slider).getImage();
        g2d.drawImage(img, trackRect.x, trackRect.y, trackRect.width, trackRect.height, slider);

    }

    @Override
    public void paintThumb(Graphics g) {
        Rectangle knobBounds = thumbRect;
        int w = knobBounds.width;
        int h = 100;
        int newStarty = knobBounds.height/2- h/2;
        g.translate(knobBounds.x, knobBounds.y);

        //     "plain" version
        g.setColor(Color.YELLOW);
        g.fillRect(0, newStarty, w, h);

    }

    @Override
    protected TrackListener createTrackListener(JSlider slider) {
        return new TrackListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (UIManager.getBoolean("Slider.onlyLeftMouseButtonDrag")
                        && SwingUtilities.isLeftMouseButton(e)) {
                    JSlider slider = (JSlider) e.getComponent();
                    switch (slider.getOrientation()) {
                    case SwingConstants.VERTICAL:
                        slider.setValue(valueForYPosition(e.getY()));
                        break;
                    case SwingConstants.HORIZONTAL:
                        slider.setValue(valueForXPosition(e.getX()));
                        break;
                    default:
                        throw new IllegalArgumentException(
                                "orientation must be one of: VERTICAL, HORIZONTAL");
                    }
                    super.mousePressed(e); // isDragging = true;
                    super.mouseDragged(e);
                } else {
                    super.mousePressed(e);
                }
            }

            @Override
            public boolean shouldScroll(int direction) {
                return false;
            }
        };
    }
}