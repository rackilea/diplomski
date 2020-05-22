import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

@SuppressWarnings("serial")
public class TerminalFormWithTextArea extends JPanel {
   private static final int GAP = 3;
   private static final int ENTER_TEXT_AREA_ROWS = 3;
   private JTextArea textarea;
   private JTextArea enterTextArea;
   private String userName;

   public TerminalFormWithTextArea(String userName, int rows, int cols, InputStream inStream,
         PrintStream printStream) {
      this.userName = userName;
      textarea = prepareTextArea(rows, cols, inStream);
      enterTextArea = prepareEnterTextArea(cols, printStream, textarea);

      setLayout(new BorderLayout(GAP, GAP));
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      add(new JScrollPane(textarea), BorderLayout.CENTER);
      add(new JScrollPane(enterTextArea), BorderLayout.SOUTH);
   }

   public String getUserName() {
      return userName;
   }

   private JTextArea prepareEnterTextArea(int cols, PrintStream printStream,
         JTextArea textArea) {
      JTextArea enterTxtArea = new JTextArea(ENTER_TEXT_AREA_ROWS, cols);
      enterTxtArea.setWrapStyleWord(true);
      enterTxtArea.setLineWrap(true);
      // textField.addActionListener(new TextFieldListener(printStream, textArea));
      int condition = JComponent.WHEN_FOCUSED;
      InputMap inputMap = enterTxtArea.getInputMap(condition);
      ActionMap actionMap = enterTxtArea.getActionMap();

      KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
      String enter = "enter";
      inputMap.put(enterKeyStroke, enter);
      actionMap.put(enter, new EnterAction(printStream, enterTxtArea, textArea));
      return enterTxtArea;
   }

   private JTextArea prepareTextArea(int rows, int cols, InputStream inStream) {
      JTextArea textArea = new JTextArea(rows, cols);
      textArea.setEditable(false);
      textArea.setFocusable(false);
      textArea.setWrapStyleWord(true);
      textArea.setLineWrap(true);
      InputStreamWorker instreamWorker = new InputStreamWorker(textArea,
            inStream);
      instreamWorker.execute();
      return textArea;
   }

   private class EnterAction extends AbstractAction {
      private PrintStream printStream;
      private JTextArea enterTxtArea;
      private JTextArea textArea;

      public EnterAction(PrintStream printStream, JTextArea enterTextArea,
            JTextArea textArea) {
         this.printStream = printStream;
         this.enterTxtArea = enterTextArea;
         this.textArea = textArea;
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         String text = userName + "> " + enterTxtArea.getText();
         enterTxtArea.setText("");
         printStream.println(text);
         textArea.append(text + "\n");
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
      TerminalFormWithTextArea mainPanel = new TerminalFormWithTextArea(userName, rows, cols, inStream,
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