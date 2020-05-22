import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Loging {

    Connection con;
    Statement st;
    ResultSet rs;

    JFrame f = new JFrame("User Login");
    JLabel l = new JLabel("Username");
    JLabel l1 = new JLabel("password");
    JTextField t = new JTextField(10);
    JTextField t1 = new JTextField(10);
    JButton b = new JButton("Login");

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    public void Loging1() {
        connect();
        frame();
    }

    public void connect() {
        try {
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";//Driver needed for connection
            Class.forName(driver);//    Class.forName(driver);

            String db = "jdbc:odbc:db1";
            con = DriverManager.getConnection(db);
            st = con.createStatement();

        } catch (Exception ex) {

        }

    }

    public void frame() {
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        JPanel p = new JPanel();
        p.add(l);
        p.add(t);
        p.add(l1);
        p.add(t1);
        p.add(b);

        f.add(p);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    String user = t.getText().trim();
                    String pass = t1.getText().trim();

                    String sql = "select user, pass from Table1 where user = '" + user + "'and pass = '" + pass + "'";//for sql query
                    //String sql = "select user, pass from Table1 where user = '"+user+"'pass = '"+pass+"'";
                    //Getting the fields user and pass checks tthat both are equal to each orther
                    rs = st.executeQuery(sql);//executes query  

                    int count = 0;//cont the rows for the query
                    while (rs.next()) {
                        count = count + 1;//if no rows are returned then no user exist, if count is = to 1 then user exist              }
                    }

                    if (count == 1)//if = to 1 user exist
                    {
                        JOptionPane.showMessageDialog(null, "Logged in!");
                    } else if (count > 1)//if more that one
                    {
                        JOptionPane.showMessageDialog(null, "Duplicate user, DENIED!");
                    } else {
                        JOptionPane.showMessageDialog(null, "user not found");
                    }

                } catch (Exception ex) {

                }
                //public static void main(String[] args) {

            }
            //  New Loging1 ();
        });
    }
}