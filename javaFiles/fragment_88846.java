import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class chattcp extends JFrame {

public static void main(String args[]) {
    chattcp peer1 = new chattcp("peer1", 9999, 9998);
    chattcp peer2 = new chattcp("peer2", 9998, 9999);
}

chattcp(String name, int lis, int snd) {
    this.setVisible(true);
    this.setTitle(name);
    this.setLayout(null);
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    TextField tf = new TextField();
    this.add(tf);
    tf.setBounds(10, 20, 100, 40);

    TextArea ta = new TextArea();
    this.add(ta);
    ta.setBounds(10, 80, 400, 400);
    ta.setEditable(false);
    ta.setFont(ta.getFont().deriveFont(20f));
    Button b = new Button("send");
    this.add(b);
    b.setBounds(130, 20, 60, 40);
    b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent a) {
            try {
                String s = tf.getText();
                Socket skt = new Socket("localhost", snd);
                DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
                dos.writeUTF(s);
                ta.append("You :" + s + "\n");
                tf.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

    Thread receive = new Thread() {
        public void run() {
            try {
                while (true) {
                    ServerSocket ser = new ServerSocket(lis);
                    Socket sktt = ser.accept();
                    DataInputStream dis = new DataInputStream(sktt.getInputStream());

                    String s = dis.readUTF();
                    ta.append("Friend : " + s + "\n");

                    ser.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
    receive.start();

}
}