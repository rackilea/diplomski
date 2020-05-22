import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;

    public class Reg{

        public static void main (String[]args)throws IOException {

            Users p = new Users();
            String uu = "";
            String pp = "";
            String ss = "";
            //I think you created a method in Users and say logined or something error.
            While(Users.getLogin == false){
            //***I don't know the Users class you made

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter username");
            uu = sc.nextLine();
            p.setUser(uu);
            System.out.println("Enter password");
            pp = sc.nextLine();
            p.setPassword(pp);
            System.out.println("Enter Secret number");
            ss= sc.nextLine();
            p.setSecret(ss);

            }



            //Something like this
        if(Users.getLogin == true){
            //if you wanna write something to the file, u can use this.
        FileWriter fw = new FileWriter("output.txt");
        PrintWriter pw = new PrintWriter(fw);
            pw.write(uu);
            pw.write(pp);
            pw.write(ss);

            //if you wanna write line by line use writeln, not write.


        pw.close();

    }
        }
}