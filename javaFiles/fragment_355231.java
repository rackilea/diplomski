import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Test {
public static void main(String[] args) {
    JFrame frame = new JFrame();
    final JTextPane tp = new JTextPane();
    tp.setContentType ( "text/html" );
    final JTextField tf = new JTextField();
    JScrollPane sp = new JScrollPane();
    JPanel panel = new JPanel();
    final File file = new File("log.txt");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(350,410);
    tp.setEditable(false);
    tp.setForeground(Color.blue);
    tf.setText("> ");
    sp.setViewportView(tp);
    GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panel);
    panel.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(tf)
            .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
    jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
    frame.getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
    );
    frame.addWindowListener( new WindowAdapter() {
        public void windowOpened( WindowEvent e ){
            tf.requestFocus();
        }
    });
    /**File file10 = new File("Rooms/Room1/roomDescription.txt");
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    PrintStream old = System.out;
    System.setOut(ps);

    try {
        FileReader fr = new FileReader(file10);
        int ch = fr.read();

        while(ch != -1) {
            System.out.print((char) ch);
            ch = fr.read();
        }
    } catch (Exception ex) {

    }
    System.out.flush();
    System.setOut(old);
    tp.setText(baos.toString());
    try {
        FileWriter fw = new FileWriter(file);
        fw.write(tp.getText());
        fw.close();
    } catch (IOException ioe) {

    }*/

    tp.setText("You find yourself in a blank room with a cot and a small stool. The walls are made of cold " +
            "grey concrete and have been sanded smooth. There is a solid iron door set into one of the walls." +
            " There are no windows." +
            "\nWhat do you want to do?" +
            "\n" +
            "\n");

    tf.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String newline = "\n";
            if(tf.getText().equals("> inspect cot")) {  
                String string = tf.getText();
                tp.setText(tp.getText()+string + newline);
                tf.setText("> ");
                File file1 = new File("Rooms/Room1/inspectCot.txt");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                PrintStream old = System.out;
                System.setOut(ps);

                try {
                    FileReader fr = new FileReader(file1);
                    int ch = fr.read();

                    while(ch != -1) {
                        System.out.print((char) ch);
                        ch = fr.read();
                    }
                } catch (Exception ex) {

                }

                System.out.flush();
                System.setOut(old);
                tp.setText(tp.getText() + (baos.toString()));
                try {
                    FileWriter fw = new FileWriter(file);
                    fw.write(tp.getText());
                    fw.close();
                } catch (IOException ioe) {

                }
            } else {
                tf.setText("> ");
                tp.setText("<html>any string <font color='red'>> ERROR: Invalid Command</font></html>" + newline);
                try {
                    FileWriter fw = new FileWriter(file);
                    fw.write(tp.getText());
                    fw.close();
                } catch (IOException ioe) {

                }
            }
        }
    });
}
}