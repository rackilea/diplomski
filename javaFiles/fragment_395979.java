import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ScrollbarTest
{
    private JScrollPane scrollPane;
    private JScrollBar scrollBar;
    private JPopupMenu popupMenu;
    private JLabel popupLabel;

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                new ScrollbarTest();
            }
        });
    }

    public ScrollbarTest()
    {
        JFrame frame = new JFrame("Test");

        popupMenu = new JPopupMenu();
        popupLabel = new JLabel();
        popupMenu.add(popupLabel);

        scrollPane = new JScrollPane(buildTestTextArea());
        scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.addMouseMotionListener(new PopUpMouseMotionListener());
        scrollBar.addMouseListener(new PopUpMouseListener());

        frame.add(scrollPane);

        frame.setSize(new Dimension(400, 400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JTextArea buildTestTextArea()
    {
        JTextArea textArea = new JTextArea();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; ++i)
        {
            builder.append("X");
        }
        textArea.setText(builder.toString());
        textArea.setLineWrap(true);
        return textArea;
    }

    private class PopUpMouseMotionListener extends MouseMotionAdapter
    {
        @Override
        public void mouseDragged(MouseEvent e)
        {
            double value = scrollBar.getValue();
            double max = scrollBar.getMaximum() - scrollBar.getVisibleAmount();
            double h = scrollBar.getHeight();
            popupLabel.setText("" + (int) (100*value/max) + "%");
            popupMenu.show(scrollPane, scrollBar.getX() - popupMenu.getWidth() - 2, (int) ((h - popupMenu.getHeight())*value/max));
        }
    }

    private class PopUpMouseListener extends MouseAdapter
    {
        @Override
        public void mouseReleased(MouseEvent e)
        {
            popupMenu.setVisible(false);
        }
    }
}