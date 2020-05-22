import java.awt.*;
import javax.swing.*;

public class SelectCardPanel extends JPanel{
    private final JLabel cardArea;
    private final JTextArea cardInfo;

    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Yu-Gi-Oh!");
                SelectCardPanel panel = new SelectCardPanel();
                panel.setImage(new ImageIcon(SelectCardPanel.class.getResource("images.jpg")));
                frame.add(panel);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public SelectCardPanel(){
        super();

        setLayout(new BorderLayout());
        //setPreferredSize(new Dimension(200, 400));

        cardArea = new JLabel();
        cardArea.setOpaque(true);
        cardArea.setBackground(Color.white);
        //cardArea.setPreferredSize(new Dimension(200, 300));
        //cardArea.setSize(cardArea.getPreferredSize());
        cardArea.setBorder(BorderFactory.createLineBorder(Color.black));

        cardInfo = new JTextArea(5, 0);
        cardInfo.setEditable(false);
        cardInfo.setWrapStyleWord(true);
        cardInfo.setLineWrap(true);
        //cardInfo.setPreferredSize(new Dimension(200, 100));
        cardInfo.setBorder(BorderFactory.createLineBorder(Color.black));

        add(cardArea);
        add(cardInfo, BorderLayout.PAGE_END);
    }

    public final void setImage(ImageIcon icon){
        cardArea.setIcon(icon);
    }
}