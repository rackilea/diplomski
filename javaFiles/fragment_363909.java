import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DnDTransferableTest {

    public static void main(String[] args) {
        new DnDTransferableTest();
    }

    public DnDTransferableTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    @SuppressWarnings("serial")
    public class TestPane extends JPanel {

        private JList<ListItem> list;
        private JLabel label;

        public TestPane() {

            list = new JList<ListItem>();
            list.setDragEnabled(true);
            list.setTransferHandler(new ListTransferHandler());

            DefaultListModel<ListItem> model = new DefaultListModel<ListItem>();
            for (int index = 0; index < 10; index++) {

                model.addElement(new ListItem("Item " + index));

            }
            list.setModel(model);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(list), gbc);

            label = new JLabel("Drag on me...");
            gbc.gridx++;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(label, gbc);

            label.setTransferHandler(new ListTransferHandler());

        }
    }

    @SuppressWarnings("serial")
    public class ListTransferHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferSupport support) {
            return (support.getComponent() instanceof JLabel) && support.isDataFlavorSupported(ListItemTransferable.LIST_ITEM_DATA_FLAVOR);
        }

        @Override
        public boolean importData(TransferSupport support) {
            boolean accept = false;
            if (canImport(support)) {
                try {
                    Transferable t = support.getTransferable();
                    Object value = t.getTransferData(ListItemTransferable.LIST_ITEM_DATA_FLAVOR);
                    if (value instanceof ListItem) {
                        Component component = support.getComponent();
                        if (component instanceof JLabel) {
                            ((JLabel)component).setText(((ListItem)value).getText());
                            accept = true;
                        }
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            return accept;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return DnDConstants.ACTION_COPY_OR_MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            Transferable t = null;
            if (c instanceof JList) {
                @SuppressWarnings("unchecked")
                JList<ListItem> list = (JList<ListItem>) c;
                Object value = list.getSelectedValue();
                if (value instanceof ListItem) {
                    ListItem li = (ListItem) value;
                    t = new ListItemTransferable(li);
                }
            }
            return t;
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            System.out.println("ExportDone");
            // Here you need to decide how to handle the completion of the transfer,
            // should you remove the item from the list or not...
        }
    }

    public static class ListItemTransferable implements Transferable {

        public static final DataFlavor LIST_ITEM_DATA_FLAVOR = new DataFlavor(ListItem.class, "java/ListItem");
        private ListItem listItem;

        public ListItemTransferable(ListItem listItem) {
            this.listItem = listItem;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{LIST_ITEM_DATA_FLAVOR};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(LIST_ITEM_DATA_FLAVOR);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {

            return listItem;

        }
    }

    public static class ListItem {

        private String text;

        public ListItem(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return getText();
        }
    }
}