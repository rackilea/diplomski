import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DymanicDownloadList {

    // the GUI as seen by the user (without frame)
    JPanel gui = new JPanel(new BorderLayout(2, 2));

    public void initGUI() {
        gui.setBorder(new EmptyBorder(2, 3, 2, 3));

        JToolBar tb = new JToolBar();
        gui.add(tb, BorderLayout.PAGE_START);

        final DefaultListModel<Download> listModel =
                new DefaultListModel<Download>();
        final JList<Download> list = new JList<Download>(listModel);
        list.setCellRenderer(new DownloadListCellRenderer());
        list.setVisibleRowCount(3);
        gui.add(new JScrollPane(list), BorderLayout.CENTER);

        Action add = new AbstractAction("Add Download") {

            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement(new Download());
            }
        };

        Action delete = new AbstractAction("Delete Download") {

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                if (index < 0) {
                    JOptionPane.showMessageDialog(
                            list,
                            "Select a download to delete!",
                            "Select Download",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    listModel.removeElementAt(index);
                }
            }
        };

        tb.add(add);
        tb.addSeparator();
        tb.add(delete);

        for (int ii = 0; ii < 2; ii++) {
            listModel.addElement(new Download());
        }
    }

    public JComponent getGUI() {
        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                DymanicDownloadList ddl = new DymanicDownloadList();
                ddl.initGUI();

                JFrame f = new JFrame("Dynamic LIST");
                f.add(ddl.getGUI());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See https://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}

class Download {

    Download() {
    }
}

class DownloadListCellRenderer extends DefaultListCellRenderer {

    JPanel downloadPanel = new JPanel(new BorderLayout(10, 10));
    JPanel labelStack = new JPanel(new GridLayout(0, 1, 2, 2));
    JLabel number = new JLabel("", SwingConstants.CENTER);
    JLabel source = new JLabel("File Name Label", SwingConstants.CENTER);
    JLabel info = new JLabel("Download Info Label", SwingConstants.CENTER);
    JLabel free = new JLabel("Free Label", SwingConstants.CENTER);
    JProgressBar progress = new JProgressBar() {
        @Override
        public Dimension getPreferredSize() {
            Dimension d = super.getPreferredSize();

            return new Dimension(400,d.height);
        }
    };

    DownloadListCellRenderer() {
        downloadPanel.add(labelStack, BorderLayout.CENTER);
        labelStack.setOpaque(false);
        number.setFont(number.getFont().deriveFont(40f));
        labelStack.add(source);
        labelStack.add(info);
        labelStack.add(progress);
        labelStack.add(free);
        downloadPanel.add(labelStack, BorderLayout.CENTER);
        downloadPanel.add(number, BorderLayout.LINE_START);
    }

    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        JLabel l = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
        downloadPanel.setBackground(l.getBackground());
        number.setText("" + (index + 1));

        return downloadPanel;
    }
}