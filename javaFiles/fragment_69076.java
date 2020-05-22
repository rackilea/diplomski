import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

   Chess chessPanel = new Chess();
   JButton newGameButton = new JButton("New Game");
   JButton loadGameButton = new JButton("Load Game");
   JButton saveGameButton = new JButton("Save Game");
   JButton exitButton = new JButton("Exit");

   public static void main(String[] args) {
      new Main();
   }

   Main() {
      super("Chess");
      add(chessPanel, BorderLayout.CENTER);

      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new FlowLayout());

      buttonPanel.add(newGameButton);
      buttonPanel.add(loadGameButton);
      buttonPanel.add(saveGameButton);
      buttonPanel.add(exitButton);

      System.out.printf("chessPanel Size before rendering: %s%n", chessPanel.getSize());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      add(buttonPanel, BorderLayout.SOUTH);
      pack();
      System.out.printf("chessPanel Size after rendering: %s%n", chessPanel.getSize());
      setLocationRelativeTo(null);
      setVisible(true);
   }

   // ... Code ...
}

@SuppressWarnings("serial")
class Chess extends JPanel {
   private static final int CHESS_WIDTH = 600;
   private static final int CHESS_HEIGHT = CHESS_WIDTH;
   private static final int MAX_ROW = 8;
   private static final int MAX_COL = 8;
   private static final Color LIGHT_COLOR = new Color(240, 190, 40);
   private static final Color DARK_COLOR = new Color(180, 50, 0);

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(CHESS_WIDTH, CHESS_HEIGHT);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      int panelWidth = getWidth();
      int panelHeight = getHeight();
      int sqrWidth = panelWidth / MAX_ROW;
      int sqrHeight = panelHeight / MAX_COL;
      for (int row = 0; row < MAX_ROW; row++) {
         for (int col = 0; col < MAX_COL; col++) {
            Color c = (row % 2 == col % 2) ? LIGHT_COLOR : DARK_COLOR;
            g.setColor(c);
            int x = (row * panelWidth) / MAX_ROW;
            int y = (col * panelHeight) / MAX_COL;
            g.fillRect(x, y, sqrWidth, sqrHeight);
         }
      }
   }
}