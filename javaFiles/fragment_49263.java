import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class FakeCommandPrompt {

private JTextArea myTextArea;
private JScrollPane scrollPane;
private JFrame mainFrame;

/**
 * Setup the fake command prompt.
 */
public FakeCommandPrompt()
{
    mainFrame = new JFrame();
    mainFrame.setBounds(new Rectangle(new Dimension(500, 400)));
    mainFrame.setBackground(Color.BLACK);

    myTextArea = new JTextArea();
    myTextArea.setBackground(Color.BLACK);
    myTextArea.setForeground(Color.WHITE);
    myTextArea.setEditable(false);
    myTextArea.setMargin(new Insets(10, 10, 10, 10));

    scrollPane = new JScrollPane(myTextArea);
    scrollPane.setBackground(Color.BLACK);

    mainFrame.add(scrollPane);
    mainFrame.setVisible(true);
}

public void printToCommandPrompt(String text)
{
    // Append the new next to the command prompt
    // Add a new line at the end
    this.myTextArea.append(text + "\n");
}

/**
 * @param args
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub

    // Create and instance of the fake command prompt.
    FakeCommandPrompt commandPrompt = new FakeCommandPrompt();

    // Prints 0 -> 5 on the fake command prompt.
    for (int i = 0; i <= 5; i++)
    {
        commandPrompt.printToCommandPrompt(String.valueOf(i));
    }
}

}