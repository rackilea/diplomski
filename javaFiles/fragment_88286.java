public class Studentlogin extends JFrame{
    public static void main(String[] args) {
        new Studentlogin().go();
    }

    private void go() {
        Container c = getContentPane();

        setTitle(" Staff Signin ");
        setSize( 400 , 300);
        setLayout(new FlowLayout());
        setVisible(true);
        setLayout(null);

        JLabel tun = new JLabel("UserName");
        tun.setBounds(10,10,140,25);
        c.add(sun);

        JTextField tuname = new JTextField(10);
        tuname.setToolTipText("Enter your StaffId ");
        tuname.setBounds(145,10,200,25);
        c.add(tuname);

        JLabel tpw = new JLabel("PassWord");
        tpw.setBounds(10,50,140,25);
        c.add(tpw);

        JPasswordField tpword = new JPasswordField(10);
        tpword.setEchoChar('*');
        tpword.setBounds(145,50,200,25);
        c.add(tpword);
    }

}