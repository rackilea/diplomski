package alltests;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SpielFenster extends JFrame implements KeyListener{
    int posX = 100;
    int posY = 100;

    SpielFenster(){
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        this.setSize( 400, 600 );
        this.setTitle( "Hindi Bones - Lost in Labyrinth" );
        this.addKeyListener(this);//here <<<<<
        this.setVisible( true );
    }
    public void paint(Graphics g) { 
        super.paint(g);
        g.setColor(Color.ORANGE);
        g.fillOval(posX, posY, 20, 20); 
    }

    public static void main(String[] args){
        SpielFenster fenster = new SpielFenster();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        test("test");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        test("test");           
    }

    @Override
    public void keyTyped(KeyEvent e) {
        test("test");           
    }
    public void test(String x){
        System.out.println(x);
    }
}