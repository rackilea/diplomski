public class MainProgram extends JFrame implements ActionListener {
// Omit some code
private Guy jim; // (1)
private Guy bob;

public static void main(String[] args) {
    // Omit some code

    Guy jim = new Guy(); // (2)
    Guy bob = new Guy();

    jim.ReceiveCash(200, jimBalance);

    // Omit some code
}

// Omit some code

public void actionPerformed(ActionEvent e) {
    jim.GiveCash(100.0, jimBalance); // (3)
}