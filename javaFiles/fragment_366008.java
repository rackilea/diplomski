import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Test1 {

    //Step1 - Declaring variables
    private JFrame myFrame;
    // Added by me
    private JPanel contentPane;
    private JPanel myPanel;
    private JLabel username=null;
    private JLabel password=null;
    private JTextField usernameField=null;
    private JPasswordField passwordField=null;
    private Color myColor=new Color(200, 102, 204);
    private Font myFont11=new Font("Tahoma", 1, 11);
    private Font myFont12bold=new Font("Tahoma", Font.BOLD, 12);
    private Font myFont11bold=new Font("Tahoma", Font.BOLD, 11);

    //Step2 - Creating Components
    public void createComponents() {

        contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createTitledBorder("My Program"));

        username=new JLabel("Username");
        username.setLabelFor(usernameField);
        username.setFont(myFont11);
        username.setForeground(Color.white);
        password=new JLabel("Password");
        password.setLabelFor(passwordField);
        password.setFont(myFont11);
        password.setForeground(Color.white);
        usernameField=new JTextField(10);
        usernameField.setBorder(new LineBorder(null, 0, false));
        passwordField=new JPasswordField(10);
        passwordField.setBorder(new LineBorder(null, 0, false));

        //Panel
        myPanel=new JPanel();
        myPanel.setOpaque(true);
        myPanel.setBorder(BorderFactory.createTitledBorder("Login"));
        myPanel.setBackground(myColor);
        myPanel.setLayout(new GridLayout(2, 2, 2, 2));
        myPanel.add(username);
        myPanel.add(usernameField);
        myPanel.add(password);
        myPanel.add(passwordField);
        //----------------------------------------------------------
        contentPane.add(myPanel);

        myFrame=new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //myFrame.setPreferredSize(new Dimension(400,300));//width:400px, height:300px
        myFrame.setLocationRelativeTo(null);//to show at center of screen
        myFrame.setTitle("My Program");
        //myFrame.add(myPanel);
        myFrame.setContentPane(contentPane);
        myFrame.pack();//this alone will not give the frame a size
        myFrame.setVisible(true);
    }   

    //Step3 - Main Function
    public static void main(String[] arg) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Test1().createComponents();
            }
        });
    }

}