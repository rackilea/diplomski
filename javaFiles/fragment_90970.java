import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.*;
import java.io.*;
import java.beans.XMLEncoder;

public class SerializeTreeModel {

    private JComponent ui = null;

    SerializeTreeModel() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout());
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        JTree tree = new JTree();
        tree.setVisibleRowCount(18);
        DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        XMLEncoder xmlEncoder = new XMLEncoder(outStream);
        xmlEncoder.writeObject(treeModel);
        xmlEncoder.flush();
        ui.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(tree),
                new JScrollPane(new JTextArea(outStream.toString(), 2, 64))));
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                SerializeTreeModel o = new SerializeTreeModel();

                JFrame f = new JFrame("Serialize a TreeModel");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}