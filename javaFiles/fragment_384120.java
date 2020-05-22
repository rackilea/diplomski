class MyDialog extends JDialog {

    private static final List<Image> ICONS = Arrays.asList(
            new ImageIcon("icon_16.png").getImage(), 
            new ImageIcon("icon_32.png").getImage(),
            new ImageIcon("icon_64.png").getImage());

    MyDialog() {
        super(new DummyFrame("Name on task bar", ICONS));
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (!visible) {
            ((DummyFrame)getParent()).dispose();
        }
    }
}

class DummyFrame extends JFrame {
    DummyFrame(String title, List<? extends Image> iconImages) {
        super(title);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setIconImages(iconImages);
    }
}