public class Window1 extends JFrame {             
    private final String username;
    private final String password;


    public Window1 (final String username, final String password) {
        this.username = username;
        this.password = password;

        // do initial stuff for you frame here

        this.setVisible(true);
    }

    // have to implement actual button action listener here
    private onButtonClick() {
        final Window2 = new Window2(this);

        this.setVisible(false);           
    }

}