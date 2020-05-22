public class One extends JFrame {

    public One() {
        setVisible(true);
        setSize(400, 400);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("Mouse being moved...");
            }
        });
    }

    public static void main(String[] args) {
        One a = new One();
    }
}