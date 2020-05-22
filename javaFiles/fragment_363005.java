public class ObserverPanel extends JPanel implements TextGeneratorObserver {

    private JLabel label;

    public ObserverPanel() {
        label = new JLabel("...");
        add(label);
    }

    @Override
    public void textGenerated(String text) {
        label.setText(text);
    }

}