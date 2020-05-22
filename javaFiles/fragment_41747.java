/*
 * This component will draw "Alien" faces
 */
public class FaceComponent extends JComponent {

    Face[] faces = new Face[3];

    FaceComponent() {
        Random r = new Random();
        for (int ii=0; ii<faces.length; ii++) {
            Point p = new Point(r.nextInt(200), r.nextInt(100));
            faces[ii] = new Face(p);
        }
    }

//Create a constructor that will create a face and place it in a variable.
    public void paintComponent(Graphics g) {
        //Recover Graphics2D
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Face face : faces) {
            face.draw(g2);
        }
    }

    Dimension prefSize = new Dimension(180, 260);

    @Override
    public Dimension getPreferredSize() {
        return prefSize;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, new FaceComponent());
            }
        };
        SwingUtilities.invokeLater(r);
    }
}