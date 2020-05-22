import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GetSuccessiveInputs {
   private static void createAndShowGui() {
      Data data = new Data();

      GetInputPanel inputPanel = new GetInputPanel();
      inputPanel.setPrompt("Please enter your name:");
      inputPanel.setAction(new GetDataAction(inputPanel, data));

      JFrame frame = new JFrame("GetSuccessiveInputs");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(inputPanel);
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