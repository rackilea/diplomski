public class Gui extends JPanel implements Runnable {
    private Thread animator;
    int x = 0, y = 0, velX = 2, velY = 2;
    Timer t;

    ArrayList<myBall> myBalls = new ArrayList<>();

    @Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (myBall ball: myBalls) {
            int x = ball.getX();
            int y = ball.getY();
            Ellipse2D ellipse = new Ellipse2D.Double(x, y, 40, 40);
            g2.fill(ellipse); 
        }
    }

    public void cycle() {
        for (myBall ball: myBalls) {
            int x = ball.getX();
            int y = ball.getY();

            if(x < 0 || x > 560) {
                ball.reverseX();
            }
            if(y < 0 || y > 360) {
                ball.reverseY();
            }

            ball.move();
            System.out.println(x);
        }
    }

    @Override
    public void run() {
        while(true) {
            for (int i = 0; i < 600; i++) {
                cycle();
                repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }   
        }
    }

    public void addBalls() {
        for (int i = 0; i < 4; i++) {
            int x = (int )(Math.random() * 560);
            int y = (int )(Math.random() * 360);
            int velX = -5;
            int velY = 5;
            myBalls.add(new myBall(x, y, velX, velY));
        }
    }
}