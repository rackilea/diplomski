public class DesktopPane extends JDesktopPane {

    public DesktopPane() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                revalidate();
                repaint();
            }
        });
    }

    /*...*/

}