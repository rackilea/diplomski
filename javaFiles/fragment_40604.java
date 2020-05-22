import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

@SuppressWarnings("serial")
public class JProgressHealth extends JPanel {
    public static final String[] PLAYER_NAMES = {"John", "Steve", "Frank", "Judy", "Hillary", "Billy"};
    private List<Player> players = new ArrayList<>();

    public JProgressHealth(Window owner) {
        setLayout(new GridLayout(0, 1));
        for (String playerName : PLAYER_NAMES) {
            Player player = new Player(playerName);
            final JProgressBar progressBar = new JProgressBar(Player.HEALTH_MIN, Player.HEALTH_MAX);
            progressBar.setStringPainted(true);
            progressBar.setValue(player.getHealth());
            player.addPropertyChangeListener(Player.HEALTH, pcEvent -> setProgress(progressBar, player));            
            JPanel titlePanel = new JPanel(new BorderLayout());
            titlePanel.add(progressBar);
            titlePanel.setBorder(BorderFactory.createTitledBorder(player.getName()));
            add(titlePanel);

            // create player panels to illustrate how this works
            PlayerPanel playerPanel = new PlayerPanel(player);
            JDialog dialog = new JDialog(owner, player.getName(), ModalityType.MODELESS);
            dialog.add(playerPanel);
            dialog.pack();
            dialog.setLocationByPlatform(true);
            dialog.setVisible(true);
        }
    }

    // make JPanel wider
    @Override
    public Dimension getPreferredSize() {
        Dimension superSize = super.getPreferredSize();
        int w = 3 * superSize.width;
        int h = superSize.height;
        return new Dimension(w, h);
    }

    private void setProgress(JProgressBar progressBar, Player player) {
        int health = player.getHealth();
        progressBar.setValue(health);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Health");

        JProgressHealth mainPanel = new JProgressHealth(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}