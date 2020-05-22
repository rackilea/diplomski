import java.awt.*;
import javax.swing.*;
import java.net.URL;

class CounterFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private MyPanel myComponent = new MyPanel();
    private JLabel contentPane;

    CounterFrame() {
        try {
            URL url = new URL("http://pscode.org/media/stromlo2.jpg");
            contentPane = new JLabel(new ImageIcon(url));
        } catch(Throwable t) {
            t.printStackTrace();
        }
        contentPane.setLayout(new GridBagLayout());
        setContentPane(contentPane);
        add(myComponent);
    }

    public static void main(String[] args) {
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                CounterFrame rc = new CounterFrame();
                rc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                rc.pack();
                rc.setVisible(true);
            }

        });
    }
    }

    class MyPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private String target;
    private String raised = "200000";
    private Image background;

    public MyPanel() {
        setPreferredSize(new Dimension(200,100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D twoD = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        twoD.setRenderingHints(rh);

        twoD.setColor(Color.BLACK);

        twoD.drawString(raised,5, 90);
    }
}