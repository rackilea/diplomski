import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        String Admin = "coach2";
        String Admin_Pass = "1234";

        try {
            BufferedReader br = new BufferedReader(new FileReader(("USER_Account.txt")));

            String s;
            String TOU;
            String UIusername; //txt_Username.getText();
            String UIpassword; //txt_Password.getText();
            boolean loggedIn = false;
            while ((s = br.readLine()) != null && !loggedIn) {
                String tmp[] = s.split("-");

                UIusername = tmp[0];
                UIpassword = tmp[1];
                TOU = tmp[2];

                if (Admin.equals(UIusername) && Admin_Pass.equals(UIpassword) && TOU.equals("Sport Coach")) {
                    JOptionPane.showMessageDialog(null, "Logged in as Coach!", "", JOptionPane.INFORMATION_MESSAGE);
                    loggedIn = true;
                } else if (Admin.equals(UIusername) && Admin_Pass.equals(UIpassword) && TOU.equals("Customer")) {
                    JOptionPane.showMessageDialog(null, "Logged in as Customer!", "", JOptionPane.INFORMATION_MESSAGE);
                    loggedIn = true;
                } else if (Admin.equals("admin") && Admin_Pass.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Logged in as Admin!", "", JOptionPane.INFORMATION_MESSAGE);
                    loggedIn = true;
                }
            }
            if (!loggedIn)JOptionPane.showMessageDialog(null, "Invalid Username / Password, please retry!", "", JOptionPane.ERROR_MESSAGE);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}