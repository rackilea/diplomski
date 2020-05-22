import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.*;
import java.awt.event.*;

public class GUIScanner {
    JFrame frame = new JFrame("Port Scanner");
    JTextField textField = new JTextField("", 20);
    JPanel panel = new JPanel();
    JButton button = new JButton("Scan");
    JButton button2 = new JButton("Stop");
    JLabel label = new JLabel("");
    boolean stopped = false;

    PausableSwingWorker<Void, String> scanningWorker;

    abstract class PausableSwingWorker<K, V> extends SwingWorker<K, V> {

        private volatile boolean isPaused;
        final Object lock = new Object();

        public final void pause() {

            if (!isPaused() && !isDone()) {
                isPaused = true;
            }
        }

        public final void resume() {
            if (isPaused() && !isDone()) {
                isPaused = false;
                synchronized(lock) {
                    lock.notify();
                }
            }
        }
        public final boolean isPaused() {
            return isPaused;
        }
    }

    public GUIScanner() {
        initialize();
    }

    public static void main(String[] args) {
        GUIScanner scanner = new GUIScanner();
    }

    public void initialize() {
        panel.add(textField);
        panel.add(button);
        panel.add(button2);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String address = textField.getText().toString();
                scanHost(address, 200);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!stopped) {
                    stopped = true;
                    button2.setText("Resume");
                    scanningWorker.pause();
                } else {
                    stopped = false;
                    button2.setText("Stop");
                    scanningWorker.resume();
                }
            }
        });
    }

    public void scanHost(String ip, int timeout) {
        scanningWorker = new PausableSwingWorker<Void, String>() {
            @Override
            public Void doInBackground() {

                for (int port = 0; port <= 65535; port++) {
                    if (!isPaused()) {
                        frame.setTitle("Scanning port " + port + " of 65535");
                        Socket socket = new Socket();
                        try {
                            socket.connect(new InetSocketAddress(ip, port), timeout);
                            socket.close();
                            System.out.println("Port " + port + " is open");
                        } catch (IOException e) {
                        }
                    }
                    else {
                        synchronized(lock) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
                return null;
            }
            @Override
            public void done() {
            }
        };
    scanningWorker.execute();
    }
}