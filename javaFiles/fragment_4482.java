import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class JFormattedExample
{
    private String lastValidValue;

    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("JFormattedTextField Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        final JFormattedTextField ftf = new JFormattedTextField(
                            NumberFormat.getNumberInstance());
        ftf.setColumns(10);
        ftf.setFocusLostBehavior(JFormattedTextField.PERSIST);
        ftf.setValue(100);
        lastValidValue = "100";
        ftf.addCaretListener(new CaretListener()
        {
            public void caretUpdate(CaretEvent ce)
            {
                System.out.println("Last Valid Value : " + lastValidValue);
                if (ftf.isEditValid())
                {
                    String latestValue = ftf.getText();
                    System.out.println("Latest Value : " + latestValue);
                    if (!(latestValue.equals(lastValidValue)))
                        ftf.setBackground(Color.YELLOW.darker());
                    else
                    {
                        lastValidValue = ftf.getText();
                        ftf.setBackground(Color.WHITE);
                    }
                }
                else
                {
                    System.out.println("Invalid Edit Entered.");
                }
            }
        });

        contentPane.add(ftf);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new JFormattedExample().createAndDisplayGUI();
            }
        });
    }
}