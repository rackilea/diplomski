import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Cards10 extends Applet
{

    String deckCards[] = {"c1.gif", "c2.gif", "c3.gif", "c4.gif", "c5.gif", "c6.gif", "c7.gif", "c8.gif", "c9.gif", "c10.gif", "cj.gif", "ck.gif", "cq.gif", "s1.gif", "s2.gif", "s3.gif", "s4.gif", "s5.gif", "s6.gif", "s7.gif", "s8.gif", "s9.gif", "s10.gif", "sj.gif", "sk.gif", "sq.gif", "d1.gif", "d2.gif", "d3.gif", "d4.gif", "d5.gif", "d6.gif", "d7.gif", "d8.gif", "d9.gif", "d10.gif", "dj.gif", "dk.gif", "dq.gif", "h1.gif", "h2.gif", "h3.gif", "h4.gif", "h5.gif", "h6.gif", "h7.gif", "h8.gif", "h9.gif", "h10.gif", "hj.gif", "hk.gif", "hq.gif"};
    Random rand = new Random();
    Image[] card = new Image[10];


    public void init()
    {
        for(int k = 0; k < 11; k++){
            int r = rand.nextInt(51);
            card[k] = getImage(getDocumentBase(), deckCards[r]);
        }
        flipped = getImage(getDocumentBase(), "b1fv.gif");
    }

    public void paint(Graphics g)
    {
        g.drawImage(flipped, 10, 10, this);
        for(int i = 1;i<6;i++) g.drawImage(card[i], 10 + (40*i), 10, this);
        for(int i = 6;i<10;i++) g.drawImage(card[i], 10 + (40*(i-6)), 125, this);
    }
}