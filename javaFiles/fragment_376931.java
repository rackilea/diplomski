import java.awt.datatransfer.*;
import java.awt.dnd.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.List;

public class FileDragList extends JPanel implements DropTargetListener {

    private static final long serialVersionUID = 1L;
    private DefaultListModel listModel = new DefaultListModel();
    private JScrollPane jScrollPane1;
    private JList list;

    /**
     * Create the panel.
     */
    public FileDragList() {
        setLayout(null);        
        list = new JList();
        DropTarget dropTarget = new DropTarget(list, this);
        list.setModel(listModel);
        list.setDragEnabled(true);
        FileListCellRenderer renderer = new FileListCellRenderer();
        list.setCellRenderer(renderer);
        //list.setTransferHandler(new FileTransferHandler());
        jScrollPane1 = new JScrollPane();

        jScrollPane1.setViewportView(list);
        jScrollPane1.setBounds(10, 150, 635, 330);
        add(jScrollPane1);

    }
    public static void main(String[] args) throws Exception {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, new FileDragList());
            }
        };
        SwingUtilities.invokeLater(r);
    }

    public void dragEnter(DropTargetDragEvent arg0) {
        // nothing
    }

    public void dragOver(DropTargetDragEvent arg0) {
        // nothing
    }

    public void dropActionChanged(DropTargetDragEvent arg0) {
        // nothing
    }

    public void dragExit(DropTargetEvent arg0) {
        // nothing
    }

    public void drop(DropTargetDropEvent evt) {
        int action = evt.getDropAction();
        evt.acceptDrop(action);
        try {
            Transferable data = evt.getTransferable();
            if (data.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                List<File> files = (List<File>) data.getTransferData(DataFlavor.javaFileListFlavor);
                for (File file : files) {

                    Icon icon=FileSystemView.getFileSystemView().getSystemIcon(file);
                    /////////////////listModel.addElement(filepath+icon);///////////////////////want code do this

                }
            }
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            evt.dropComplete(true);
        }
    }
}