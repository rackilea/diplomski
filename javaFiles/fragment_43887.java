public class Gamey extends JFrame {
    // Other fields
    private String name;
    // Getter & setter for name

    ...

    public static void main(String[] args) {
        Gamey game = new Gamey();
        game.setName(JOptionPane.showInputDialog(null, "enter name: ")); // Set the name with the value from the input dialog
    ...
    }
}