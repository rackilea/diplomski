public class ImageButton extends Canvas {
    private int mouse = 0;
    private boolean hit = false;

    public ImageButton(Composite parent, int style) {
        super(parent, style);

        this.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent e) {
                switch (mouse) {
                case 0:
                    // Default state
                    e.gc.drawString("Normal", 5, 5);
                    break;
                case 1:
                    // Mouse over
                    e.gc.drawString("Mouse over", 5, 5);
                    break;
                case 2:
                    // Mouse down
                    e.gc.drawString("Hit", 5, 5);
                    break;
                }
            }
        });
        this.addMouseMoveListener(new MouseMoveListener() {
            public void mouseMove(MouseEvent e) {
                if (!hit)
                    return;
                mouse = 2;
                if (e.x < 0 || e.y < 0 || e.x > getBounds().width
                        || e.y > getBounds().height) {
                    mouse = 0;
                }
                redraw();
            }
        });
        this.addMouseTrackListener(new MouseTrackAdapter() {
            public void mouseEnter(MouseEvent e) {
                mouse = 1;
                redraw();
            }

            public void mouseExit(MouseEvent e) {
                mouse = 0;
                redraw();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            public void mouseDown(MouseEvent e) {
                hit = true;
                mouse = 2;
                redraw();
            }

            public void mouseUp(MouseEvent e) {
                hit = false;
                mouse = 1;
                if (e.x < 0 || e.y < 0 || e.x > getBounds().width
                        || e.y > getBounds().height) {
                    mouse = 0;
                }
                redraw();
                if (mouse == 1)
                    notifyListeners(SWT.Selection, new Event());
            }
        });
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.keyCode == '\r' || e.character == ' ') {
                    Event event = new Event();
                    notifyListeners(SWT.Selection, event);
                }
            }
        });
    }

}