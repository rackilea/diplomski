import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RectangleDrawingTest extends JFrame {

    public RectangleDrawingTest() {
        createAndShowUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                RectangleDrawingTest drawingTest = new RectangleDrawingTest();
            }
        });
    }

    private void createAndShowUI() {
        setTitle("Rectangle Drawing Test");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        addComponentsToContentPane(this.getContentPane());
        setVisible(true);
    }

    private void addComponentsToContentPane(Container contentPane) {

        Rectangle[] recs = new Rectangle[3];
        recs[0] = new Rectangle(100, 100, 150, 100);
        recs[1] = new Rectangle(100, 100, 125, 75);
        recs[2] = new Rectangle(100, 100, 100, 50);

        MyPanel mr = new MyPanel(recs);

        contentPane.add(mr);
    }
}

class MyPanel extends JPanel {

    private final Rectangle[] recs;

    public MyPanel(Rectangle[] recs) {
        this.recs = recs;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(Color.BLACK);
        for (int i = 0; i < recs.length; i++) {
            grphcs.drawRect(recs[i].x, recs[i].y, recs[i].width, recs[i].height);
        }
    }
}