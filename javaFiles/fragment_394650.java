import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.swingx.prompt.PromptSupport;

public class PromptExample {

    public static void main(String[] args) {
        new PromptExample();
    }

    public PromptExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTextField bunnies = new JTextField(10);
                JTextField ponnies = new JTextField(10);
                JTextField unicorns = new JTextField(10);
                JTextField fairies = new JTextField(10);

                PromptSupport.setPrompt("Bunnies", bunnies);
                PromptSupport.setPrompt("Ponnies", ponnies);
                PromptSupport.setPrompt("Unicorns", unicorns);
                PromptSupport.setPrompt("Fairies", fairies);

                PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, bunnies);
                PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIGHLIGHT_PROMPT, ponnies);
                PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, unicorns);

                PromptSupport.setFontStyle(Font.BOLD, bunnies);
                PromptSupport.setFontStyle(Font.ITALIC, ponnies);
                PromptSupport.setFontStyle(Font.ITALIC | Font.BOLD, unicorns);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                frame.add(bunnies, gbc);
                frame.add(ponnies, gbc);
                frame.add(unicorns, gbc);
                frame.add(fairies, gbc);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}