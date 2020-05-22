package SO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class miClass implements ActionListener {


  JFrame ventana;
  JPanel panel;
  JButton p, c;
  Graphics g;
  Image img;
  Font font1, font2, font3;

  public miClass() {
    ventana = new JFrame("Aplicacion.");
    p = new JButton("P");
    c = new JButton("C");
    panel = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        // your stuff
        font1 = new Font("Helvetica", Font.PLAIN, 22);
        g.setFont(font1);
        g.drawString("THIS GETS REDRAWN", 100, 300);
      }
    };
    panel.setSize(400, 400);
    ventana.setLayout(null);
    ventana.setBounds(100, 100, 600, 600);
    ventana.getContentPane().add(panel);
    ventana.add(p);
    p.addActionListener(this);
    c.addActionListener(this);
    p.setBounds(20, 20, 120, 45);
    ventana.add(c);
    c.setBounds(200, 20, 120, 45);
    ventana.setFocusable(true);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    g = panel.getGraphics();
    Toolkit tool = Toolkit.getDefaultToolkit();
    img = tool.getImage("prueba.png");
    g.drawImage(img, 0, 100, null);

    font1 = new Font("Helvetica", Font.PLAIN, 22);
    g.setFont(font1);
    g.drawString("Hola", 100, 300);

    font2 = new Font("TimesRoman", Font.BOLD, 20);
    g.setFont(font2);
    g.drawString("Mundo", 100, 340);

    font3 = new Font("Courier", Font.BOLD + Font.ITALIC, 25);
    g.setFont(font3);
    g.drawString("WASAAAA!", 100, 400);

    g.setColor(Color.green);
    g.drawOval(300, 200, 150, 100);
    g.setColor(Color.red);
    g.drawArc(200, 400, 250, 64, 135, 46);
    g.setColor(Color.blue);
    g.drawLine(400, 200, 150, 100);
    g.setColor(Color.magenta);
    g.drawRect(300, 250, 160, 50);
    g.setColor(Color.cyan);
    g.fillRect(100, 400, 20, 240);
    g.setColor(Color.lightGray);
    g.fillOval(100, 340, 14, 30);

    if (e.getSource() == c) { // Clean all objects on the window//
      g.clearRect(0, 100, 900, 800);
    }
  }

  public static void main(String args[]) {
    miClass GUI = new miClass();
  }



}