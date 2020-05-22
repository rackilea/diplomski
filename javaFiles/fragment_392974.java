import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class PlayerDrawingPanel extends JPanel {
    private int playerX;
    private int playerY;
    private Player player;

    public PlayerDrawingPanel(int playerX, int playerY, Player player) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.player = player;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
        repaint();
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(player.getImage(), playerX, playerY, this);
    }
}