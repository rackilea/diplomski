import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class TestTimerTable {

    String[] cols = {"ID", "Name", "Country Code", "District", "Population"};
    DefaultTableModel model = new DefaultTableModel(cols, 0);
    JTable table = new JTable(model);
    ResultSet rs = null;
    JButton start = new JButton("Start");
    Timer timer = new Timer(0, null);

    public TestTimerTable() {
        initDB();

        JScrollPane scroll = new JScrollPane(table);
        scroll.setViewportView(table);

        JFrame frame = new JFrame("Test Timer Table");
        frame.add(scroll);
        frame.add(start, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (rs.next()) {
                        String s1 = rs.getString(1);
                        String s2 = rs.getString(2);
                        String s3 = rs.getString(3);
                        String s4 = rs.getString(4);
                        String s5 = rs.getString(5);
                        model.addRow(new Object[]{s1, s2, s3, s4, s5});
                    } else {
                        ((Timer) e.getSource()).stop();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
    }

    private void initDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/...", "...", "...");
            PreparedStatement ps = conn.prepareStatement("SELECT *  FROM city");
            rs = ps.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestTimerTable();
            }
        });
    }
}