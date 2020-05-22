import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class MyTttFoo extends JPanel {
   // it's OK for constants to be static
   private static final long serialVersionUID = 1L;
   private static final int ROWS = 3;

   // use a larger Font to make buttons larger
   private static final Font BTN_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 60);
   private static final String BLANK = "   ";
   private static final String X = "X";
   private static final String O = "O";

   // but not most variables
   private JButton[][] buttonGrid = new JButton[ROWS][ROWS];

   public MyTttFoo() {
      setBackground(Color.black);

      // use layout managers to help you create your GUI
      setLayout(new GridLayout(ROWS, ROWS, 1, 1));
      ActionListener btnListener = new ButtonListener();
      // create your buttons and add them only **once**
      for (int row = 0; row < buttonGrid.length; row++) {
         for (int col = 0; col < buttonGrid[row].length; col++) {
            JButton button = new JButton(BLANK);
            button.setFont(BTN_FONT);
            button.addActionListener(btnListener);
            add(button);  // add button to a gridlayout using component
            buttonGrid[row][col] = button; // and assign into the array
         }
      }
   }

   private class ButtonListener implements ActionListener {
      private boolean xTurn = true;

      @Override
      public void actionPerformed(ActionEvent e) {
         AbstractButton btn = (AbstractButton) e.getSource();
         String txt = btn.getText();
         if (txt.equals(BLANK)) {
            if (xTurn) {
               btn.setText(X);
            } else {
               btn.setText(O);               
            }
            xTurn = !xTurn;
         } 
      }
   }

   private static void createAndShowGui() {
      MyTttFoo mainPanel = new MyTttFoo();

      JFrame frame = new JFrame("MyTttFoo");
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