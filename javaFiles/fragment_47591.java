import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestBatGui extends JPanel {
   public static final String BATCH_FILE_PATH = "test.bat";
   private JTextArea resultArea = new JTextArea(30, 80);

   public TestBatGui() {
      resultArea.setFocusable(false); // not allow user edits
      resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
      JScrollPane scrollPane = new JScrollPane(resultArea);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      int keyCode = KeyEvent.VK_H;
      String path = System.getProperty("user.home");
      buttonPanel.add(new JButton(new ShowDirAction("Home Dir", keyCode, path)));

      keyCode = KeyEvent.VK_W;
      path = System.getProperty("user.dir");
      buttonPanel.add(new JButton(new ShowDirAction("Working Dir", keyCode,
            path)));

      setLayout(new BorderLayout());
      add(scrollPane, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.PAGE_END);
   }

   // Action/ActionListener to be used by my buttons
   private class ShowDirAction extends AbstractAction {
      private String path;

      public ShowDirAction(String name, int keyCode, String path) {
         super(name);
         putValue(MNEMONIC_KEY, keyCode);
         this.path = path;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // our SwingWorker
         BatchFileWorker batchFileWorker = new BatchFileWorker(
               resultArea, BATCH_FILE_PATH, path);
         // add a listener to respond when the worker is done
         batchFileWorker.addPropertyChangeListener(new BatchFileWorkerListener());
         batchFileWorker.execute(); // execute the worker
      }
   }

   // class to listen for when the worker has completed its work
   // and then this class extracts the SwingWorker's results via .get()
   // and does house cleaning if need be.
   private class BatchFileWorkerListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
            BatchFileWorker worker = (BatchFileWorker) evt.getSource();
            try {
               // extract the result returned from the worker's doInBackground() method
               // and most importantly, trap any exceptions thrown
               int exitValue = worker.get();
               String displayText = "";
               if (exitValue != 0) {
                  displayText = String.format("Error when running batch, Exit Value: %d", exitValue);
               } else {
                  displayText = "Batch file ran without error";
               }
               ((Consumer<String>) worker).accept(displayText);
               ((Consumer<String>) worker).accept("\n");
            } catch (InterruptedException e) {
               e.printStackTrace();
            } catch (ExecutionException e) {
               e.printStackTrace();
            }
         }
      }
   }

   // Our SwingWorker. It's also a Consumer so that outside classes, namely the InputConsumer
   // can pass the strings that it reads back into the worker via the accept(...) method
   private class BatchFileWorker extends SwingWorker<Integer, String> implements Consumer<String> {
      private JTextArea resultArea;
      private String batchFilePath;
      private String dirPath;

      public BatchFileWorker(JTextArea resultArea, String batchFilePath,
            String dirPath) {
         this.resultArea = resultArea;
         this.batchFilePath = batchFilePath;
         this.dirPath = dirPath;
      }

      @Override
      protected Integer doInBackground() throws Exception {
         // command list to load into the process builder
         List<String> commandList = new ArrayList<>();
         int exitCode = 0;
         publish("Getting dir for " + dirPath);
         commandList.add("cmd");
         commandList.add("/c");
         commandList.add(batchFilePath);
         commandList.add(dirPath);

         // create the process builder
         ProcessBuilder pBuilder = new ProcessBuilder(commandList);

         // add the error stream to the input stream so now we have only one stream to handle 
         pBuilder.redirectErrorStream();  
         Process p = pBuilder.start(); // create our process
         InputStream is = p.getInputStream();  // get its InputStream and use it 
         InputStreamReader isr = new InputStreamReader(is);  // to create a 
         BufferedReader br = new BufferedReader(isr);  // BufferedReader
         InputConsumer consumer = new InputConsumer(br, this); // pass into our consumer object
         Thread thread = new Thread(consumer); // start this in a background thread
         thread.start();
         exitCode = p.waitFor(); // wait in this thread for the error code
         thread.join(); // join two threads
         br.close();  // close the BufferedReader
         return exitCode;
      }

      @Override // this allows our InputConsumer to pass Strings read back into the SwingWorker
      public void accept(String text) {
         publish(text);
      }

      @Override // published text will be sent here on the EDT, to be placed into the JTextArea
      protected void process(List<String> chunks) {
         for (String chunk : chunks) {
            resultArea.append(chunk + "\n"); 
         }
      }
   }

   // to read in from the BufferedReader, passing text back into its consumer
   private class InputConsumer implements Runnable {
      private BufferedReader br;
      private Consumer<String> consumer;

      public InputConsumer(BufferedReader br, Consumer<String> consumer) {
         this.br = br;
         this.consumer = consumer;
      }

      @Override
      public void run() {
         String line = null;
         try {
            while ((line = br.readLine()) != null) {
               consumer.accept(line);
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   private static void createAndShowGui() {
      TestBatGui mainPanel = new TestBatGui();

      JFrame frame = new JFrame("TestBatGui");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}