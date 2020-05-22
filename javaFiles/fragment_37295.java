import java.awt.FlowLayout;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.Scanner;

 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JPasswordField;
 import javax.swing.JRadioButton;
 import javax.swing.JTextField;

public class Applic {

//This will be the file where the username and password will be saved
File file = new File(System.getProperty("user.home")+"/Desktop/save.txt");


//Window,buttons etc...
JFrame frame= new JFrame();
JTextField name = new JTextField(20);
JPasswordField password = new JPasswordField(20);
JRadioButton remember = new JRadioButton("Remember me");
JButton Enter = new JButton("Enter");

   public Applic(){


     //Create the Window
       frame.setSize(250,200);
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);
       frame.setLayout(new FlowLayout());

       //Add The items to window
       frame.add(name);
       frame.add(password);
       frame.add(remember);
       frame.add(Enter);


       UPDATE(); //Check if password and this User is Saved (very simple for one user)
       frame.setVisible(true);


       //Add A mouseAdapter(or whatever you want
       Enter.addMouseListener(new MouseAdapter(){
           public void mouseReleased(MouseEvent m){

               if(remember.isSelected()){
                  SAVE(); //Save This UserName and his PassWord     
               }

           }//end of mouseReleased
       });
   }


public static void main(String[] args){
    new Applic();
}


  public void SAVE(){      //Save the UserName and Password (for one user)



        try {
            if(!file.exists()) file.createNewFile();  //if the file !exist create a new one

            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            bw.write(name.getText()); //write the name
            bw.newLine(); //leave a new Line
            bw.write(password.getPassword()); //write the password
            bw.close(); //close the BufferdWriter

        } catch (IOException e) { e.printStackTrace(); }        

 }//End Of Save




  public void UPDATE(){ //UPDATE ON OPENING THE APPLICATION

        try {
          if(file.exists()){    //if this file exists

            Scanner scan = new Scanner(file);   //Use Scanner to read the File

            name.setText(scan.nextLine());  //append the text to name field
            password.setText(scan.nextLine()); //append the text to password field
            scan.close();
          }

        } catch (FileNotFoundException e) {         
            e.printStackTrace();
        }                

   }//End OF UPDATE



}//End Of Class [Applic]