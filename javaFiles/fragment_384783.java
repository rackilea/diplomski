import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyGUI extends JFrame{  
    private JTextField idField;
    private JTextField nameField;
    private JTextField mailField;
    public MyGUI(){  

        setTitle("Settings");


        getContentPane().setLayout(null);

        JLabel lblUserid = new JLabel("User-ID");
        lblUserid.setBounds(12, 22, 100, 24);
        getContentPane().add(lblUserid);

        JLabel lblUsername = new JLabel("User-Name");
        lblUsername.setBounds(12, 50, 100, 24);
        getContentPane().add(lblUsername);

        JLabel lblUserMail = new JLabel("User-Mail");
        lblUserMail.setBounds(12, 77, 100, 24);
        getContentPane().add(lblUserMail);



        idField = new JTextField();
        idField.setBounds(114, 22, 124, 24);
        getContentPane().add(idField);
        idField.setColumns(10);

        nameField = new JTextField();
        nameField.setColumns(10);
        nameField.setBounds(114, 50, 124, 24);
        getContentPane().add(nameField);

        mailField = new JTextField();
        mailField.setColumns(10);
        mailField.setBounds(114, 77, 124, 24);
        getContentPane().add(mailField);



        JButton btnSave = new JButton("Save");
        btnSave.setBounds(114, 105, 124, 25);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        getContentPane().add(btnSave);
        setBounds(10, 10, 270,270);

        setResizable(false);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(300,200));
        setPreferredSize(new Dimension(300,200));
        setVisible(true);
    }  


    protected void saveData(){
        String id = this.idField.getText();
        String name = this.nameField.getText();
        String mail = this.mailField.getText();
        // you have to validate these inputs before inserting to data base      
        User user = new User(id, name, mail);
        boolean result = user.doUpdate(true, true);
        if( result ){
            JOptionPane.showMessageDialog(this,"Saved successfully");
        }else{
            JOptionPane.showMessageDialog(this,"DB Failure...");
        }
    }  

    public static void main(String [] params){
        new MyGUI();
    }
}