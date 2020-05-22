public class Paint extends JFrame implements ... {

    //...

    // Method for different drawing stencils
    public void paint(Graphics g) {
        if (p != null) {
            g.setColor(c);
            switch (shapeType) {
                case 0:
                    g.drawOval(p.x - w / 2, p.y - h / 2, w, h);
                    break;
                case 1:
                    g.drawRect(p.x - w / 2, p.y - h / 2, w, h);
                    break;

            }

        }

        // Resets application window surface to white (clears the canvas)
        if (Refresh == true) {
            g.setColor(Color.white);
            g.fillRect(0, 0, 1500, 1500);

        }
        g.drawImage(key, 0, 0, this);

        if (widthincrease == true) {
            w += 1;
        }
        if (heightincrease == true) {
            h += 1;
        }
        if (widthdecrease == true) {
            w -= 1;

            if (w < 1) {
                w = 50;
            }
        }

        if (heightdecrease == true) {
            h -= 1;

            if (h < 1) {
                h = 50;
            }
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        repaint();
    }

    public void update(Graphics g) {
        paint(g);
    }
}