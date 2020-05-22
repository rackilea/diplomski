import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestNativeDnD {
    protected void initUI() {
        final JFrame frame = new JFrame(TestNativeDnD.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel dropTargetComponent = new JLabel("Drop something here") {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 600);
            }
        };
        dropTargetComponent.setHorizontalAlignment(JLabel.CENTER);
        final JLabel testLabel = new JLabel();
        new DropTarget(dropTargetComponent, DnDConstants.ACTION_COPY, new DropTargetListener() {

            @Override
            public void drop(DropTargetDropEvent dtde) {
                try {
                    Transferable tr = dtde.getTransferable();
                    dtde.acceptDrop(DnDConstants.ACTION_COPY);
                    if (tr.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.imageFlavor)) {
                        Image image = (Image) tr.getTransferData(java.awt.datatransfer.DataFlavor.imageFlavor);
                        showImageIcon(new ImageIcon(image));
                    } else if (tr.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.javaFileListFlavor)) {
                        List<File> fileList = (List<File>) tr.getTransferData(java.awt.datatransfer.DataFlavor.javaFileListFlavor);
                        Iterator<File> iterator = fileList.iterator();
                        if (iterator.hasNext()) {
                            File file = iterator.next();
                            showImageIcon(new ImageIcon(file.getAbsolutePath()));
                        }
                    } else {
                        DataFlavor[] flavors = tr.getTransferDataFlavors();
                        boolean handled = false;
                        for (int i = 0; i < flavors.length; i++) {
                            if (flavors[i].isRepresentationClassReader()) {
                                Reader reader = flavors[i].getReaderForText(tr);
                                BufferedReader br = new BufferedReader(reader);
                                java.lang.String line = null;
                                while ((line = br.readLine()) != null) {
                                    try {
                                        // kde seems to append a 0 char to the end of the reader
                                        if ("0".equals(line)) {
                                            continue;
                                        }
                                        File file = new File(new URI(line));
                                        showImageIcon(new ImageIcon(file.getAbsolutePath()));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                } catch (UnsupportedFlavorException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void showImageIcon(ImageIcon icon) {
                testLabel.setIcon(icon);
                frame.pack();
            }

            @Override
            public void dragEnter(DropTargetDragEvent dtde) {
                // TODO Auto-generated method stub

            }

            @Override
            public void dragOver(DropTargetDragEvent dtde) {
                // TODO Auto-generated method stub

            }

            @Override
            public void dropActionChanged(DropTargetDragEvent dtde) {
                // TODO Auto-generated method stub

            }

            @Override
            public void dragExit(DropTargetEvent dte) {
                // TODO Auto-generated method stub

            }

        });
        frame.add(dropTargetComponent);
        frame.add(testLabel, BorderLayout.EAST);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestNativeDnD().initUI();
            }
        });
    }

}