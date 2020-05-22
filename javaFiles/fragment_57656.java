import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

@SuppressWarnings("serial")
public class CardGameGui extends JPanel {
   public static final String[] PLAYER_NAMES = {"John", "Bill", "Frank", "Andy"};
   private static final Color ACTIVE_BG = Color.pink;

   // a Map that allows us to associate a JLabel with a CardPlayer
   private Map<CardPlayer, JLabel> playerLabelMap = new HashMap<CardPlayer, JLabel>();
   private CardPlayers cardPlayers = new CardPlayers(PLAYER_NAMES);
   public CardPlayer currentPlayer = cardPlayers.getCurrentPlayer(); 

   public CardGameGui() {
      setLayout(new GridLayout(1, 0, 5, 0));

      for (CardPlayer cardPlayer : cardPlayers) {
         JLabel playerLabel = createPlayerLabel(cardPlayer);
         playerLabelMap.put(cardPlayer, playerLabel);
         add(playerLabel);
      }

      playerLabelMap.get(currentPlayer).setBackground(ACTIVE_BG);
      cardPlayers.addPropertyChangeListener(new CardPlayersListener());
   }

   private JLabel createPlayerLabel(CardPlayer player) {
      JLabel label = new JLabel(player.getName());
      label.setOpaque(true);
      int ebGap = 15;
      label.setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));
      label.addMouseListener(new PlayerLabelListener());
      return label;
   }

   public void activateCurrentLabel(CardPlayer currentPlayer) {
      for (CardPlayer cardPlayer : cardPlayers) {
         playerLabelMap.get(cardPlayer).setBackground(null);
      }

      playerLabelMap.get(currentPlayer).setBackground(ACTIVE_BG);
   }


   private class CardPlayersListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (CardPlayers.CARD_PLAYER.equals(evt.getPropertyName())) {
            currentPlayer = cardPlayers.getCurrentPlayer();
            System.out.println(currentPlayer);
            activateCurrentLabel(currentPlayer);
         }
      }
   }

   private class PlayerLabelListener extends MouseAdapter {

      @Override
      public void mousePressed(MouseEvent mEvt) {
         JLabel playerLabel = (JLabel) mEvt.getSource();
         JLabel currentPlayerLabel = playerLabelMap.get(currentPlayer);

         if (playerLabel == currentPlayerLabel) {
            cardPlayers.incrementPlayerIndex();
         }
      }
   }

   private static void createAndShowGui() {
      CardGameGui mainPanel = new CardGameGui();

      JFrame frame = new JFrame("CardGame");
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

class CardPlayers implements Iterable<CardPlayer> {
   public static final String CARD_PLAYER = "card player";
   private List<CardPlayer> playerList = new ArrayList<>();
   private int currentPlayerIndex = 0;
   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(
         this);

   public CardPlayers(String[] playerNames) {
      for (String playerName : playerNames) {
         playerList.add(new CardPlayer(playerName));
      }
   }

   public CardPlayer getCurrentPlayer() {
      return playerList.get(currentPlayerIndex);
   }

   public void incrementPlayerIndex() {
      CardPlayer oldValue = getCurrentPlayer();
      currentPlayerIndex++;
      currentPlayerIndex %= playerList.size();
      CardPlayer newValue = getCurrentPlayer();
      pcSupport.firePropertyChange(CARD_PLAYER, oldValue, newValue);
   }

   @Override
   public Iterator<CardPlayer> iterator() {
      return playerList.iterator();
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

}


class CardPlayer {
   private String name;

   public CardPlayer(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "CardPlayer: " + name;
   }

}