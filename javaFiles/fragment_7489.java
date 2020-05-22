import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Instructor {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());

        final JTextPane textPane;
        textPane = new JTextPane();
        frame.add(textPane,BorderLayout.CENTER);

        JButton button = new JButton("Read CSV");
        button.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e) {
                //Reset textpanes content so on every button click the new content of the read file will be displayed
                textPane.setText("");
                String fileResult = "";                 
                try {
                BufferedReader csvReader = new BufferedReader(new FileReader("myCSV.csv"));
                String line = null;
                while ((line = csvReader.readLine()) != null) {
                    //Do your logic here which information you want to parse from the csv file and which information you want to display in your textpane
                    fileResult = fileResult + "\n" +line;
                }
                }
                catch(FileNotFoundException ex) {
                    System.err.println("File was not found");
                }
                catch(IOException ioe) {
                    System.err.println("There was an error while reading the file");
                }
                textPane.setText(fileResult);
            }
        });
        frame.add(button,BorderLayout.SOUTH);

        frame.setVisible(true);
    }

}