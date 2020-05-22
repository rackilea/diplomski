package homework;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class PassWordFrame extends JFrame
{
   private static final int FIELD_WIDTH = 10;
   private static final int FRAME_WIDTH = 500;
   private static final int FRAME_HEIGHT = 300;
   private JLabel fileRead;
   private JLabel instruct;
   private JLabel username;
   private JLabel password;
   private JTextField usertext;
   private JTextField passtext;
   private JButton login;
   private ActionListener listener;
   //String text = "";

   public PassWordFrame()
   {
      createComponents();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      login.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                String info = ReadFile();
                System.out.println(info);
                String[] split = info.split("@");
                String uname=split[0];
                String pass =split[1];
                if(usertext.getText().equals(uname) && passtext.getText().equals(pass)){
                    instruct.setText("access granted");
                }else{
                    instruct.setText("access denided");
                }
            }
        }); 

   }
   private static  String ReadFile(){
        String line=null;
        String text="";
        try{

            FileReader filereader=new FileReader(new File("G:\\password.txt"));
             //FileReader filereader=new FileReader(new File(path));
            BufferedReader bf=new BufferedReader(filereader);
            while((line=bf.readLine()) !=null){
                text=text+line;

            }
            bf.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return text;

    }


   public void createComponents()
   {
      Color blue = new Color(0,128,155);
      Font font = new Font("Times New Roman", Font.BOLD, 14);

      instruct = new JLabel("Please enter your username and password.");
      instruct.setFont(font);

      username = new JLabel("Username: ");
      username.setFont(font);

      password = new JLabel("Password: ");
      password.setFont(font);

      usertext = new JTextField(FIELD_WIDTH);
      passtext = new JTextField(FIELD_WIDTH);

      login = new JButton("Login");
      login.setFont(font);

      instruct.setForeground(Color.BLACK);
      login.setForeground(Color.BLACK);
      username.setForeground(Color.BLACK);
      password.setForeground(Color.BLACK);

      login.addActionListener(listener);

      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      JPanel panel3 = new JPanel();
      JPanel panel4 = new JPanel();

      panel1.setBackground(blue);
      panel2.setBackground(blue);
      panel3.setBackground(blue);
      panel4.setBackground(blue);

      panel1.add(instruct);
      panel2.add(username);
      panel2.add(usertext);
      panel3.add(password);
      panel3.add(passtext);
      panel4.add(login);

      add(panel1, BorderLayout.NORTH);
      add(panel2, BorderLayout.WEST);
      add(panel3, BorderLayout.CENTER);
      add(panel4, BorderLayout.SOUTH);

      pack();
   }
}