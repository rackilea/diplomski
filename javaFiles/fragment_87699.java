import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleGuiPanel extends JPanel {
    private static final String TITLE = "This is my Dialog Title";

    public SimpleGuiPanel() {
        JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 16f));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        buttonPanel.add(new JButton("Button 1"));
        buttonPanel.add(new JButton("Button 2"));

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        add(titleLabel, BorderLayout.PAGE_START);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private static void createAndShowGui() {
        JPanel mainFramePanel = new JPanel();
        mainFramePanel.setPreferredSize(new Dimension(500, 400));
        final JFrame mainFrame = new JFrame("Main Frame");
        mainFrame.add(mainFramePanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SimpleGuiPanel simpleGuiPanel = new SimpleGuiPanel();
        final JDialog myDialog = new JDialog(mainFrame, "Dialog", ModalityType.APPLICATION_MODAL);
        myDialog.getContentPane().add(simpleGuiPanel);
        myDialog.pack();

        mainFramePanel.add(new JButton(new AbstractAction("Show Dialog") {

            @Override
            public void actionPerformed(ActionEvent e) {
                myDialog.setLocationRelativeTo(mainFrame);
                myDialog.setVisible(true);
            }
        }));

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}