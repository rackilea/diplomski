import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Test {

    public Test() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        final JPanel labelPanel = new JPanel();
        labelPanel.setBorder(new LineBorder(Color.black));
        for (int i = 0; i < 5; i++) {
            labelPanel.add(new JLabel("Label" + (i + 1)));
        }

        final int maxWidth = 200;
        final JScrollPane jsp = new JScrollPane(labelPanel) {
            @Override
            public Dimension getPreferredSize() {
                //we set the height by checking if we exceeed the wanted ith thus a scrollbar will appear an we must incoprate that or labels wont be shpwn nicely
                return new Dimension(maxWidth, labelPanel.getPreferredSize().width < maxWidth ? (labelPanel.getPreferredSize().height + 5) : ((labelPanel.getPreferredSize().height + getHorizontalScrollBar().getPreferredSize().height) + 5));
            }
        };

        JPanel otherPanel = new JPanel();
        otherPanel.add(new JLabel("label"));
        otherPanel.setBorder(new LineBorder(Color.black));

        JPanel otherPanel2 = new JPanel();
        otherPanel2.add(new JLabel("label 1"));
        otherPanel2.add(new JLabel("label 2"));
        otherPanel2.setBorder(new LineBorder(Color.black));

        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        gc.gridx = 0;
        gc.gridy = 0;
        frame.add(jsp, gc);

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.WEST;
        gc.gridy = 1;
        frame.add(otherPanel, gc);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridy = 2;
        frame.add(otherPanel2, gc);

        frame.pack();
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        //Create Swing components on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}