public class PasswordBox {
    public String prompt(JFrame fatherFrame) {
        JPasswordField pass = new JPasswordField(10);
        int action = JOptionPane.showConfirmDialog(fatherFrame, pass,"Enter Password",JOptionPane.OK_CANCEL_OPTION); 
        return new String(pass.getPassword());
    }
}