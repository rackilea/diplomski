public class ImagePanel extends JPanel {
    private JLabel headsLabel = new JLabel();
    private JLabel tailsLabel = new JLabel();

    public ImagePanel(Icon headsIcon, Icon tailsIcon) {
        headsLabel.setIcon(headsIcon);
        tailsLabel.setIcon(tailsIcon);
        setLayout(new GridLayout(1, 0);
        add(headsLabel);
        add(tailsLabel);
    }       
}