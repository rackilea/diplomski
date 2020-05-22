import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.*;

public class Kskb {

    private int row;

    public Kskb()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setPreferredSize(new Dimension(800, 600));
//        final JPanel content = new JPanel(new GridBagLayout());
        final ScrollablePanel content = new ScrollablePanel(new GridBagLayout());
        content.setScrollableWidth( ScrollablePanel.ScrollableSizeHint.FIT );
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "");
        content.getActionMap().put("", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JPanel p = new JPanel( new BorderLayout() );
                p.setBorder( new EmptyBorder(10, 10, 10, 10) );
                p.setBackground(Color.GRAY);
                JTextArea text = new JTextArea();
                text.append("ABCABCABCABCABCABCABCABC ABCABCABCABCABCABCABCABCABCABCABCABCABCABC ABCABCABCABCABCABCABCABCABCABCABCABCABCA BCABCABCABCABCABCABCAB CABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABC");
                text.setLineWrap( true );
                p.add(text);

                gbc.gridy = row++;
                content.add(p, gbc);
                content.revalidate();
            }
        });

        JScrollPane scrollPane = new JScrollPane(content);
        f.pack();
        f.setLocationRelativeTo(null);
        f.add(scrollPane);
        f.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Kskb();
    }
}