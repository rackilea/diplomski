import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

// not a class that I'm familiar with
import com.fazecast.jSerialComm.SerialPort;

public class PortWorkerCheckPanel extends JPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PortWorkerCheckPanel portCheckPanel = new PortWorkerCheckPanel();
            JFrame frame = new JFrame("Port Check");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(portCheckPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private JTextArea textArea = new JTextArea(20, 50);
    private StartWorkerAction startAction = new StartWorkerAction(this);

    public PortWorkerCheckPanel() {
        textArea.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel btnPanel = new JPanel();
        btnPanel.add(new JButton(startAction));

        setLayout(new BorderLayout());
        add(scrollPane);
        add(btnPanel, BorderLayout.PAGE_END);
    }

    public void appendPortText(String text) {
        textArea.append(text + "\n");
    }

    private static class StartWorkerAction extends AbstractAction {
        private PortWorkerCheckPanel portCheckPanel;

        public StartWorkerAction(PortWorkerCheckPanel portCheckPanel) {
            super("Start Worker");
            this.portCheckPanel = portCheckPanel;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            Worker worker = new Worker(portCheckPanel);
            worker.addPropertyChangeListener(new WorkerListener());
            worker.execute();
        }
    }

    static class WorkerListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                Worker worker = (Worker) evt.getSource();
                try {
                    worker.get();
                } catch (InterruptedException | ExecutionException e) {
                    // TODO handle any exceptions here
                    e.printStackTrace();
                }
            }
        }
    }

    static class Worker extends SwingWorker<Void, String> {
        boolean portcheck = false;

        // Note that I have no idea if this part, the SerialPort code, is
        // correct
        // as I do not use this utility
        SerialPort comPort[] = SerialPort.getCommPorts();
        SerialPort port;
        private PortWorkerCheckPanel portCheckPanel;

        public Worker(PortWorkerCheckPanel portCheckPanel) {
            this.portCheckPanel = portCheckPanel;
        }

        protected void done() {
            System.out.println("Done");
        }

        @Override
        protected Void doInBackground() throws Exception {
            String data;

            // this code in the if block should all be done interactively in the
            // GUI,
            // not using a console-based Scanner the information should then be
            // passed
            // into this worker via a constructor parameter
            if (!portcheck) {
                int i = 1;
                System.out.println("Select a port:");
                for (SerialPort ports : comPort) {
                    System.out.println(i++ + ". " + ports.getSystemPortName());
                }

                Scanner s = new Scanner(System.in);
                int chosenPort = s.nextInt();
                port = comPort[chosenPort - 1];
                portcheck = true;
                if (port.openPort()) {
                    System.out.println("Port opened successfully");
                }
                port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
            }

            publish("Reading");
            Scanner read = new Scanner(port.getInputStream());

            while (read.hasNextLine()) {
                data = read.nextLine();
                publish(data);
            }
            if (read != null) {
                read.close();
            }
            return null;
        }

        // My process should call getPortText, which should then display the
        // received data.
        @Override
        protected void process(List<String> chunks) {
            for (String line : chunks) {
                portcheck = true;
                // PortWorkerCheckPanel.getPortText(line);
                portCheckPanel.appendPortText(line);
            }
        }
    }
}