public class Application extends PApplet {

public void setup() {
    size(600, 480, JAVA2D);
}

public void draw() {
    background(255);
}

public void closeApplication() {
    exit();
}

public static void main(String _args[]) {

    final JFrame frame = new JFrame("Embbed Applet");

    frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    JPanel panel = new JPanel();

    final Application applet = new Application();
    applet.init();

    panel.add(applet);
    frame.add(panel);
    frame.setSize(600, 510);
    frame.setResizable(false);

    frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent ev) {
            int confirm = JOptionPane.showOptionDialog(frame,
                "Want to save all unsaved data?",
                "Exit confirmation", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
            switch(confirm) {
            case JOptionPane.YES_OPTION:
                // Save data
                applet.closeApplication();
                System.exit(0);
                break;
            case JOptionPane.NO_OPTION:
                applet.closeApplication();
                System.exit(0);
                break;
            case JOptionPane.CANCEL_OPTION:
                // Do nothing
                break;
            }
        }
    });

    frame.setVisible(true);

}