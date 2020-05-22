public class TestInternalFrame {

    public static void main(String[] args) {
        new TestInternalFrame();
    }

    private int xpos = 0;
    private int ypos = 0;

    public TestInternalFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
                DesktopPane pane = new DesktopPane();
                pane.add(newInternalFrame());
                pane.add(newInternalFrame());
                pane.add(newInternalFrame());

                JFrame frame = new JFrame();
                frame.add(pane);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }

    public JInternalFrame newInternalFrame() {
        JInternalFrame inf = new JInternalFrame("Blah", true, true, true, true);
        inf.setLocation(xpos, ypos);
        inf.setSize(100, 100);
        inf.setVisible(true);

        xpos += 50;
        ypos += 50;

        return inf;
    }

    public class DesktopPane extends JDesktopPane {

        @Override
        public void doLayout() {
            super.doLayout();
            List<Component> icons = new ArrayList<Component>(25);
            for (Component comp : getComponents()) {
                if (comp instanceof JInternalFrame.JDesktopIcon) {
                    icons.add(comp);
                }
            }

            int x = 0;
            for (Component icon : icons) {

                int y = getHeight() - icon.getHeight();
                icon.setLocation(x, y);
                x += icon.getWidth();

            }
        }
    }
}