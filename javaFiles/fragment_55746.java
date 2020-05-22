import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameView extends JComponent implements ActionListener{

/**
 * 
 */
private static final long serialVersionUID = -2869672245901003704L;
private boolean liveGame;//used so that buttons cannot be clicked after game is complete
private GameState gs;
private Player p;
private int w, h;

public GameView(int width, int height)
{
    liveGame = true;
    gs = new GameState();
    GameState.init(width, height);
    p = new Player(width/2,(height*7)/8);
    this.setBackground(Color.BLACK);
    w = width;
    h = height;
}
   @Override
    public Dimension getMinimumSize() {
        return new Dimension(w, h);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    @Override
    public void paintComponent(Graphics g) {
        int margin = 10;
        Dimension dim = getSize();
        super.paintComponent(g);
        g.setColor(Color.black);
        GameState.update();

        g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);

        for(Bullet j : GameState.getEnBullets()){
            g.drawImage(j.getImage(),j.getX(), j.getY(), null);}
        for(Enemy j : GameState.getEnemies()){
            g.drawImage(j.getImage(),j.getX(), j.getY(), null);}
        for(Bullet j : GameState.getPlayBullets()){
            g.drawImage(j.getImage(),j.getX(), j.getY(), null);}

        g.drawImage(p.getImage(),p.getX(),p.getY(),null);
    }




public void refreshImage()
{
    this.removeAll();
    repaint();
}


public void actionPerformed(ActionEvent e) {


}


}