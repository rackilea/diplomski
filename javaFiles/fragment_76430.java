import java.awt.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Coop
        extends BasicGameState
{
    TextField text;
    UnicodeFont font;

    public Coop(int state)
    {
    }

    public void init(GameContainer gc , StateBasedGame sbg)
            throws SlickException
    {
        font = getNewFont("Arial" , 16);
    }

    public void render(GameContainer gc , StateBasedGame sbg , Graphics g)
            throws SlickException
    {
        text.render(gc , g);
        g.setFont(font);
    }

    public void update(GameContainer gc , StateBasedGame sbg , int delta)
            throws SlickException
    {
        font.loadGlyphs();
    }

    public int getID()
    {
        return 3;
    }

    public void enter(GameContainer gc , StateBasedGame sbg)
            throws SlickException
    {
        text = new TextField(gc , font , 150 , 270 , 200 , 35);
    }

    public UnicodeFont getNewFont(String fontName , int fontSize)
    {
        font = new UnicodeFont(new Font(fontName , Font.PLAIN , fontSize));
        font.addGlyphs("@");
        font.getEffects().add(new ColorEffect(java.awt.Color.white));
        return (font);
    }
}