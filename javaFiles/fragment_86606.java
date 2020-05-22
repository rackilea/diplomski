// Main class, which just creates a window and adds a label and shows it
public class Main{
    public static void main(String[] args) {
        Window window = new Window(1200, 800, "JFrame Example", false, JFrame.EXIT_ON_CLOSE);
        JLabel label = window.createLabel("Hi dude!!!!!", 0, 0);
        window.add(label);
        window.setVisible(true);
    }
}