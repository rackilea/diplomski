public class BallPit extends JPanel {
    //...
    private Point mousePoint;
    //...
    public BallPit() {
        //...
        MouseAdapter handler = new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                mousePoint = e.getPoint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mousePoint = null;
            }

        };

        addMouseListener(handler);
        addMouseMotionListener(handler);
        //...