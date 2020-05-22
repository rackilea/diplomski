public class Main extends JPanel implements MouseMotionListener {
public JLabel label;

public static void main(String[] args) {
    Main m = new Main();// create an object and reference it
    JFrame frame = new JFrame();
    frame.setTitle("MouseCoordinates");
    frame.setSize(400, 400);
    frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    });
    Container contentPane = frame.getContentPane();
    contentPane.add(m);
    frame.setVisible(true);
}
//...