public class AsteroidsTest {

    public static void main(String[] args){
        int[] xPoints = {0, -20, 0, 20};
        int[] yPoints = {-40, 20, 0, 20};
        Ship ship = new Ship(xPoints, yPoints, 4, 0);
        ship.center_x = 100;
        ship.center_y = 100;
        ship.angle = 45;
        ship.speed_x = 30;
        ship.speed_y = -30;

        System.out.println("running...");

        JFrame window = new JFrame();
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(new MyCanvas(ship));
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        long time1 = System.currentTimeMillis();
        while(true){
            long time2 = System.currentTimeMillis();
            double timeDiff = (time2-time1)/1000f;
            time1 = time2;
            ship.move(timeDiff);
            window.getContentPane().repaint();
        }

    }
}

class MyCanvas extends JComponent {

    private Ship ship;

    public MyCanvas(Ship ship){
        this.ship = ship;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform transform = new AffineTransform();
        transform.translate(ship.center_x, ship.center_y);
        transform.rotate(Math.toRadians(ship.angle));
        Shape transformed = transform.createTransformedShape(ship);
        g2.draw(transformed);

        Rectangle2D box = transformed.getBounds2D();
        //wrap in x direction
        if(box.getX() + box.getWidth() > 300){
            AffineTransform transform2 = new AffineTransform();
            transform2.translate(ship.center_x - 300, ship.center_y);
            transform2.rotate(Math.toRadians(ship.angle));
            Shape transformed2 = transform2.createTransformedShape(ship);
            g2.draw(transformed2);
        }else if(box.getX() < 0){
            AffineTransform transform2 = new AffineTransform();
            transform2.translate(ship.center_x + 300, ship.center_y);
            transform2.rotate(Math.toRadians(ship.angle));
            Shape transformed2 = transform2.createTransformedShape(ship);
            g2.draw(transformed2);
        }

        //wrap in y direction
        if(box.getY() + box.getHeight() > 300){
            AffineTransform transform2 = new AffineTransform();
            transform2.translate(ship.center_x, ship.center_y - 300);
            transform2.rotate(Math.toRadians(ship.angle));
            Shape transformed2 = transform2.createTransformedShape(ship);
            g2.draw(transformed2);
        }else if(box.getY() < 0){
            AffineTransform transform2 = new AffineTransform();
            transform2.translate(ship.center_x, ship.center_y + 300);
            transform2.rotate(Math.toRadians(ship.angle));
            Shape transformed2 = transform2.createTransformedShape(ship);
            g2.draw(transformed2);
        }


    }
}