import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
public class TerminalForm extends JPanel {
   private static final int GAP = 3;
   private JTextArea textarea;
   private JTextField textfield;
   private String userName;

   public TerminalForm(String userName, int rows, int cols, InputStream inStream,
         PrintStream printStream) {
      this.userName = userName;
      textarea = prepareTextArea(rows, cols, inStream);
      textfield = prepareTextField(cols, printStream, textarea);

      setLayout(new BorderLayout(GAP, GAP));
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      add(new JScrollPane(textarea), BorderLayout.CENTER);
      add(textfield, BorderLayout.SOUTH);
   }

   public String getUserName() {
      return userName;
   }

   private JTextField prepareTextField(int cols, PrintStream printStream,
         JTextArea textArea) {
      JTextField textField = new JTextField(cols);
      textField.addActionListener(new TextFieldListener(printStream, textArea));
      return textField;
   }

   private JTextArea prepareTextArea(int rows, int cols, InputStream inStream) {
      JTextArea textArea = new JTextArea(rows, cols);
      textArea.setEditable(false);
      textArea.setFocusable(false);
      InputStreamWorker instreamWorker = new InputStreamWorker(textArea,
            inStream);
      instreamWorker.execute();
      return textArea;
   }

   private class TextFieldListener implements ActionListener {
      private PrintStream printStream;
      private JTextArea textArea;

      public TextFieldListener(PrintStream printStream, JTextArea textArea) {
         this.printStream = printStream;
         this.textArea = textArea;
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         JTextComponent textComponent = (JTextComponent) evt.getSource();
         String text = textComponent.getText();
         textComponent.setText("");

         printStream.println(userName + "> " + text);
         textArea.append(userName + "> " + text + "\n");
      }
   }

   private class InputStreamWorker extends SwingWorker<Void, String> {
      private Scanner scanner;
      private JTextArea textArea;

      private InputStreamWorker(JTextArea textArea, InputStream inStream) {
         this.textArea = textArea;
         scanner = new Scanner(inStream);
      }

      @Override
      protected Void doInBackground() throws Exception {
         while (scanner.hasNextLine()) {
            publish(scanner.nextLine());
         }
         return null;
      }

      @Override
      protected void process(List<String> chunks) {
         for (String chunk : chunks) {
            textArea.append(chunk + "\n");
         }
      }
   }

   private static void createAndShowGui(String userName, final InputStream inStream,
         final PrintStream printStream) {
      int rows = 20;
      int cols = 40;
      TerminalForm mainPanel = new TerminalForm(userName, rows, cols, inStream,
            printStream);

      JFrame frame = new JFrame("Terminal Form: " + userName);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      final PipedOutputStream outStream1 = new PipedOutputStream();
      final PipedInputStream inStream1 = new PipedInputStream();

      try {
         final PipedOutputStream outStream2 = new PipedOutputStream(inStream1);
         final PipedInputStream inStream2 = new PipedInputStream(outStream1);

         createAndShowGui("John", inStream1, new PrintStream(outStream1));
         createAndShowGui("Fred", inStream2, new PrintStream(outStream2));
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}