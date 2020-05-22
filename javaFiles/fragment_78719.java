import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ProgDraftMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                ProgDraft gui = new ProgDraft();
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                gui.setResizable(false);
                gui.setSize(500 , 300);
                gui.setVisible(true);           
            }
        });
    }
}

class ProgDraft extends JFrame {
    private ImageIcon image1;
    private JLabel label1;

    ProgDraft() {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));

        ImageIcon pics = new ImageIcon(getClass().getResource("stackoverflow.png"));

        JLabel logo = new JLabel(pics);
        logo.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        panel.add(logo);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel title = new JLabel("Testing Title", JLabel.CENTER);
        Font font = new Font("impact", Font.PLAIN, 30);
        title.setFont(font);

        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(title, BorderLayout.PAGE_START);
    }
}