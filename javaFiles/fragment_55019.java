import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class SwngWrkr implements Runnable {
    private JComboBox<Object> combo;
    private JFrame frame;

    public void run() {
        showGui();
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("Interfaces"));
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<Object>();
        model.addElement("Loading...");
        combo = new JComboBox<Object>(model);
        mainPanel.add(combo);
        return mainPanel;
    }

    private void showGui() {
        frame = new JFrame("SW");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(createMainPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        new GetIfTsk(combo).execute();
    }

    public static void main(String[] args) {
        SwngWrkr instance = new SwngWrkr();
        EventQueue.invokeLater(instance);
    }
}

class GetIfTsk extends SwingWorker<Void, Void> {
    private JComboBox<Object> combo;
    private List<Object> netIfNames;

    public GetIfTsk(JComboBox<Object> combo) {
        this.combo = combo;
        netIfNames = new ArrayList<>();
    }

    protected Void doInBackground() throws Exception {
        Enumeration<NetworkInterface> ifs = NetworkInterface.getNetworkInterfaces();
        int ndx = 0;
        while (ifs.hasMoreElements()) {
            NetworkInterface ni = ifs.nextElement();
            String name = ni.getName();
            System.out.printf("%2d. %s%n", ++ndx, name);
            netIfNames.add(name);
        }
        return null;
    }

    protected void done() {
        DefaultComboBoxModel<Object> model = (DefaultComboBoxModel<Object>) combo.getModel();
        model.removeAllElements();
        model.addAll(netIfNames);
        model.setSelectedItem(netIfNames.get(0));
    }
}