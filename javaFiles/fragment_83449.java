public interface Switchable {
    void show(String card);
}

public class Login extends JFrame implements Switchable {
    LoginPanel panel = new LoginPanel(this);

    @Override
    public void show(String card) {
        CardLayout layout = (CardLayout)getLayout();
        layout.show(card);
    }
}

public class LoginPanel extends JPanel {
    private Switchable switcher;

    public LoginPanel(Switchable switcher) {
        this.switcher = switcher;
    }

    private void buttonActionPerformed(ActionEvent e) {
        switcher.show(...);
    }
}