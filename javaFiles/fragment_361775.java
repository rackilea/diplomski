import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestMap {

    private JTextArea jta = new JTextArea(15, 30);
    private JTextField jtf = new JTextField(30);
    private JButton button = new JButton("Show Job");
    private Map<String, Job> map;

    public TestMap() {
        map = getMap();

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(jta, BorderLayout.CENTER);
        panel.add(jtf, BorderLayout.NORTH);
        panel.add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!"".equals(jtf.getText())) {
                    String customer = jtf.getText();
                    if (map.containsKey(customer)) {
                        jta.append(String.valueOf(map.get(customer)));
                        jta.append("\n***********************\n\n");
                    }
                    jtf.setText("");
                }
            }
        });

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private Map<String, Job> getMap() {
        Map<String, Job> map = new HashMap<>();
        map.put("Paul", new Job(100, "Paul", 10000.00));
        map.put("Jim", new Job(101, "Jim", 20000.00));
        map.put("John", new Job(102, "John", 30000.00));
        map.put("Sean", new Job(103, "Sean", 40000.00));
        map.put("Shane", new Job(104, "Shane", 50000.00));
        map.put("Mike", new Job(105, "Mike", 60000.00));

        return map;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestMap();
            }
        });
    }
}

class Job {

    int jobNo;
    String customer;
    double creditLimit;

    public Job(int jobNo, String customer, double creditLimit) {
        this.jobNo = jobNo;
        this.customer = customer;
        this.creditLimit = creditLimit;
    }

    public String toString() {
        return "Job No: " + jobNo
                + "\nCustomer: " + customer
                + "\nCredit Limit: " + creditLimit;
    }
}