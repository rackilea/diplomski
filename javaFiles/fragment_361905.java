package codePin;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Main extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel container = new JPanel();
    private JFormattedTextField jtf = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JLabel label = new JLabel("Enter Pin: ");
    private JButton b = new JButton("OK");

    public Main() {
        this.setTitle("APP");
        this.setSize(300, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        Font police = new Font("Arial", Font.BOLD, 14);
        jtf.setFont(police);
        jtf.setPreferredSize(new Dimension(150, 30));
        jtf.setForeground(Color.BLUE);

        b.addActionListener(new BoutonListener());

        top.add(label);
        top.add(jtf);
        top.add(b);

        this.setContentPane(top);
        this.setVisible(true);
    }

    class BoutonListener implements ActionListener {
        private final AtomicInteger nbTry = new AtomicInteger(0);
        ArrayList<Integer> pins = readPinsData("bdd.txt");
        public void actionPerformed(ActionEvent e) {
            if (nbTry.get() > 2) {
                JOptionPane.showMessageDialog(null, "Number of tries exceeded");
                return;
            }
            final String passEntered=jtf.getText().replaceAll("\u00A0", "");
            if (passEntered.length() != 4) {
                System.out.println("Pin must be 4 digits");
                JOptionPane.showMessageDialog(null, "Ping must be 4 digits");
                return;
            }
            System.out.println("Checking...");
            SwingWorker worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    boolean authenticated = false;
                    if (pins.contains(Integer.parseInt(passEntered))) {
                        System.out.println(":)");
                        authenticated = true;
                    }

                    if (!authenticated) {
                        System.out.println(":(");
                        nbTry.incrementAndGet();
                    }
                    return null;
                }
            };
            worker.execute();
        }


    }

    // Function to read/access my pins database (file bdd.txt)
    static public ArrayList<Integer> readPinsData(String dataFile) {
        final ArrayList<Integer> data=new ArrayList<Integer>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(dataFile)));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    try {
                        data.add(Integer.parseInt(line));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.err.printf("error parsing line '%s'\n", line);
                    }
                }
            } finally {
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("error:"+e.getMessage());
        }

        return data;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main fen = new Main();
            }
        });

    }
}