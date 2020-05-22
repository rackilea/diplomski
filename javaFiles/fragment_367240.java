import java.io.Serializable;
import java.awt.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import org.jgroups.*;

public class JGroupsTest {

    public static void main(String[] args) throws Exception {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 300);
        final DefaultListModel listModel = new DefaultListModel();
        final JList panel = new JList(listModel);
        panel.setBackground(new Color(128, 0, 40));
        panel.setForeground(new Color(240, 240, 240));
        frame.add(panel);
        System.setProperty("java.net.preferIPv4Stack", "true");
        final JChannel channel = new JChannel("udp.xml");
        channel.connect("networkclipboard");
        channel.setReceiver(new ReceiverAdapter() {
            @Override
            public void viewAccepted(View newView) {
                frame.setTitle("Network Clipboard - " + channel.getLocalAddress());
            }

            @Override
            public void receive(Message msg) {
                listModel.addElement(msg.getObject());
            }
        });

        panel.setTransferHandler(new TransferHandler() {
            @Override
            public boolean importData(JComponent comp, Transferable t) {
                DataFlavor[] transferDataFlavors = t.getTransferDataFlavors();
                for (DataFlavor flavor : transferDataFlavors) {
                    try {
                        Object data = t.getTransferData(flavor);
                        if (data instanceof Serializable) {
                            Serializable serializable = (Serializable) data;
                            Message msg = new Message();
                            msg.setObject(serializable);
                            channel.send(msg);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return super.importData(comp, t);
            }

            @Override
            public boolean canImport(TransferSupport support) {
                return true;
            }

            @Override
            public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
                return true;
            }

        });
    }

}