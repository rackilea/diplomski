public class LaunchMenu extends Applet {

    public static LoginScreen login;
    public static Game game;
    public JButton button;
    public void init() {
        try {button= new JButton("Start the game");
        add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                login = new LoginScreen();
                login.setVisible(true); *

            }
        });
        } catch (Exception e) {
            e.getMessage();
            e.getCause();
        }
    }

    public void start() {
        login = new LoginScreen();
    }

    public void stop() {
        login.dispose();
        game.stop();
    }

    public static void main(String[] args) {

    }
}