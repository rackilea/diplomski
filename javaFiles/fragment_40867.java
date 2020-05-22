public void confirmLogin(ActionEvent e){
    Person user = new Person();
    person.setUsername(usernameField.getText());

    Program program = new Program(user);

    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
}

public class Program extends JFrame {
    JLabel usernameLabel = new JLabel();

    Program(Person user) {
        this.setSize(200,200);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        // Get the username from the user
        usernameLabel.setText(user.getUsername());
        this.add(usernameLabel);

        this.setVisible(true);
    }
}