public class DrawingSurface extends JComponent{

          public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics buffer = unscreen.getGraphics();
            buffer.setColor(Color.white);
            buffer.fillRect(0, 0, 500, 500);
            buffer.setColor(Color.black);
            buffer.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            // buffer.drawString("hours:minutes:seconds: ", 25, 100);
            buffer.drawString(hourss + numhours + ":" + minutess + numminutes + ":"
             + secondss + numseconds, 100, 100);
            g.drawImage(unscreen, 0, 0, null);
         }
   }