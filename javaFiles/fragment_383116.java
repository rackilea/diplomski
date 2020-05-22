import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Test extends JFrame {

    void printC(String foo){
        System.out.print(foo);
    }

    void read() throws IOException{
        String c = "";
        PipedOutputStream pipeOut = new PipedOutputStream();
        PipedInputStream pipeIn = new PipedInputStream(pipeOut);
        System.setOut(new PrintStream(pipeOut));
        Scanner sc = new Scanner(pipeIn);
        while(!c.equalsIgnoreCase("Quit")){
        printC("Test\n");
        c = sc.nextLine();
        JOptionPane.showMessageDialog(this, c);
        }
    }

    public static void main(String[] args) throws IOException {
        Test t = new Test();
        t.read();
    }

}