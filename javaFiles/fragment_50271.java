import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Test extends JFrame implements ActionListener {

    JButton b1, b2;
    JComboBox jc;
    String name;
    JTextField t1;
    Connection con, conn;
    Statement st;
    PreparedStatement pst;
    ResultSet rs, rs1;

    Test() {
        setLayout(null);
        JLabel l1 = new JLabel("USER SELECTION :");
        l1.setBounds(100, 100, 150, 60);
        add(l1);
        add(getUserDataCombo());
        JButton b1 = new JButton("GENERATE PART NO. :");
        b1.setBounds(70, 340, 170, 30);
        b1.addActionListener(this);
        add(b1);
        t1 = new JTextField(10);
        t1.setBounds(270, 340, 200, 30);
        add(t1);
        JButton b2 = new JButton("BACK");
        b2.setBounds(190, 420, 120, 30);
        b2.addActionListener(this);
        add(b2);
        setSize(500, 500);
        setResizable(false);
        initUserData();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JComboBox getUserDataCombo() {
        if (jc == null) {
            jc = new JComboBox();
            jc.setBounds(230, 114, 120, 30);
            jc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox combo = (JComboBox) e.getSource();
                    String data = String.valueOf(combo.getSelectedItem());
                    //TODO: Do whatever you want with the data
                }
            });
        }
        return jc;
    }

    private void initUserData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/d02", "root", "");
            st = con.createStatement();
            String s = "select Userdata from user";
            rs = st.executeQuery(s);
            while (rs.next()) {
                String name = rs.getString("Userdata");
                jc.addItem(rs.getString("Userdata"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        } finally {
            try {
                //st.close();
                rs.close();
                //con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR CLOSE");
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("GENERATE PART NO. :")) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/d02", "root", "");

                String query = "select value from user where Userdata=?";
                PreparedStatement pst = conn.prepareStatement(query);
                String tmp = (String) jc.getSelectedItem().toString();
                if (jc.getSelectedItem() != null) {
                    pst.setString(1, tmp);
                }
                ResultSet rs1 = pst.executeQuery();
                while (rs1.next()) {
                    String add = rs1.getString("value");
                    t1.setText(add);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERROR CLOSE");
            }
            if (str.equals("BACK") == true) {
                new categ();
                setVisible(false);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Test td = new Test();
    }
}