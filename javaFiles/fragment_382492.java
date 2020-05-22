import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DynamicConnection {

    protected String user = null;
    protected String pass = null;

    protected String url;

    public DynamicConnection(String url) {
        this.url = url;
    }

    public Connection getConnection() throws SQLException {
        while(user == null || pass == null) {
            askForUsernamePassword();
        }
        return DriverManager.getConnection(url, user, pass);
    }

    private void askForUsernamePassword() {
        JPanel panel = new JPanel(new GridLayout(2,2));
        panel.add(new JLabel("Username"));
        JTextField tf = new JTextField();
        panel.add(tf);
        panel.add(new JLabel("Password"));
        JPasswordField pf = new JPasswordField();
        panel.add(pf);
        if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, panel)) {
            user = tf.getText().trim();
            pass = pf.getText().trim();
        }       
    }

    public static void main(String[] args) {
        try {
            Connection con = new DynamicConnection("jdbc:postgresql://localhost:5432/bd").getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}