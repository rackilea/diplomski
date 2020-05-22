ButtonPanel btnPanel = new ButtonPanel(growPanel);

...

public class ButtonPanel extends JPanel implements ActionListener{

    private JButton btn;
    private GrowPanel growPanel;

    public ButtonPanel(GrowPanel growPanel) {
        this.growPanel = growPanel;
    }
    ...
}