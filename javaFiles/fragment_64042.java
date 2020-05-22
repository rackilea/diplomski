public class IFSwitch extends JDesktopPane {

    final JDesktopPane pane1 = this;

    public IFSwitch() {

        JFrame frame1 = new JFrame("Frame1");
        JFrame frame2 = new JFrame("Frame2");
//      JDesktopPane pane1 = new JDesktopPane();
        JDesktopPane pane2 = new JDesktopPane();
        final JInternalFrame if1 = new JInternalFrame();

        frame1.add(pane1);
        frame2.add(pane2);
        pane1.add(if1);

        if1.setBounds(10, 10, 100, 100);
        frame1.setBounds(100, 100, 200, 200);
        frame2.setBounds(500, 500, 200, 200);
        frame1.setVisible(true);
        frame2.setVisible(true);
        if1.setVisible(true);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pane2.add(if1);
        pane1.remove(if1); // You don't even need this line.
        pane1.repaint();

    }

    public static void main(String[] args) {

        new IFSwitch();
    }
}