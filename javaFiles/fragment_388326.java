import javax.swing.*;
import java.io.Console;

class Hello {
    public static void main(String[] args) {
        Console console = System.console();
        String name = console.readLine("What is your name? ");
        JLabel label = new JLabel("Hello "+name+"!");
        JFrame frame = new JFrame("Hello!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }
}