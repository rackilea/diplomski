package de.swisslife.muellerj.test;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

    public class runpaintgui  extends JFrame implements KeyListener{

      public runpaintgui(){

        this.setSize(1275, 775);
        this.setResizable(false);
        this.setTitle("game");
        this.setVisible(true);    
        this.addKeyListener(this);
        this.setVisible(true);;
      }
        int x = 30;
        public static void main(String[] args){
          runpaintgui runpaintgui = new runpaintgui();

        }
         public void paint(Graphics g){
                super.paint(g);

                g.fill3DRect(x, 30, 60, 60, true);


            }    

        public void keyTyped(KeyEvent e) {
          // TODO Auto-generated method stub

        }
        public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_LEFT){

            x = x - 5;
            repaint(); 
            System.out.println( x);
        }

        }
        public void keyReleased(KeyEvent e) {
          // TODO Auto-generated method stub

        }
    }