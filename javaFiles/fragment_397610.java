package agario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Controller {
    ArrayList<Blob> blobs = new ArrayList<Blob>();
    public ArrayList<Dot> dots = new ArrayList<Dot>();
    Blob b = new Blob(50,50,10,Color.CYAN);
    MyFrame mf = new MyFrame("Agario");
    Label l = new Label("10");
    int mouseX = 0;
    int mouseY = 0;
    static int score = 30;
    static int xDis = 0;
    static int yDis = 0;
    public static void main(String[] args){
        new Controller().startGame();
    }
    public void startGame(){
        mf.addMouseMotionListener(new MyMouseMoveListener());
        mf.add(l,BorderLayout.NORTH);
        Refresh rf = new Refresh();
        Thread t = new Thread(rf);
        t.start();

        while(true){
            try{
                Random r = new Random();
                Thread.sleep(r.nextInt(40));

                double dis = Math.sqrt(xDis*xDis + yDis*yDis);
                double easingAmount = 20;
                b.x += xDis / easingAmount;
                b.y += yDis / easingAmount;


                if(r.nextInt(10) == 5){
                    int randX = r.nextInt(600);
                    int randY = r.nextInt(600);
                    Dot d = new Dot(randX,randY);
                    synchronized(dots){
                        dots.add(d);
                    }
                    mf.add(d);
                    mf.repaint();
                }
            }catch(Exception e){

            }
        }
    }
    class Refresh implements Runnable{

        public void run() {
            while(true){
                Random ran = new Random();
                try{
                    Thread.sleep(ran.nextInt(20));
                }catch(Exception e){
                    System.out.println("error");
                }
                Rectangle r = new Rectangle(b.x,b.y,b.size,b.size);
                synchronized(dots){
                    Iterator i = dots.iterator();
                    while(i.hasNext()){
                        Dot d = (Dot) i.next();
                        Rectangle r1 = new Rectangle(d.x,d.y,d.size,d.size);
                        if(r1.intersects(r)){
                            i.remove();
                            b.size += 1;
                            l.setText(String.valueOf(Integer.parseInt(l.getText())+1));
                            score += 1;
                        }
                    }
                }
                mf.repaint();
            }

        }
    }
    class MyMouseMoveListener extends MouseMotionAdapter{
        public void mouseMoved(MouseEvent m){
            mouseX = m.getX();
            mouseY = m.getY();
            xDis = mouseX-b.x;
            yDis = mouseY-b.y;
        }
    }
    class MyFrame extends Frame{
        MyFrame(String s){
            super(s);
            setBounds(0,0,900,900);
            add(b);
            blobs.add(b);
            setVisible(true);
        }
        public void paint(Graphics g){
            for(Blob b : blobs)
                b.paint(g);
            synchronized(dots){
                Iterator i = dots.iterator();
                while(i.hasNext()){
                    Dot d = (Dot) i.next();
                    d.paint(g);
                }
            }
        }
    }
}