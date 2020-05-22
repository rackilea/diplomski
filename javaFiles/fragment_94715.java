public class Test extends JFrame {//see https://www.javatpoint.com/java-naming-conventions

    private final int MAX_ITER = 570;
    private final double ZOOM = 150;
    private volatile BufferedImage bImage; 

    public Test() throws InterruptedException {
        super("Mandelbrot Set");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < getHeight(); y++) {
            new Draw(y).execute();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bImage, 0, 0, this);
    }

    public static void main(String[] args) throws InterruptedException {
        new Test().setVisible(true);
    }

    class Draw extends SwingWorker<Void, Void>{

        private double zx, zy, cX, cY, tmp;
        private int x,y;

        Draw(int y){
            this.y = y;
        }

        @Override
        protected Void doInBackground() throws Exception {

            for ( x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cX = (x - 400) / ZOOM;
                cY = (y - 300) / ZOOM;
                int iter = MAX_ITER;
                while ((((zx * zx) + (zy * zy)) < 4) && (iter > 0)) {
                    tmp = ((zx * zx) - (zy * zy)) + cX;
                    zy = (2.0 * zx * zy) + cY;
                    zx = tmp;
                    iter--;
                }
                bImage.setRGB(x, y, iter | (iter << 8));
            }
            Thread.sleep(50); //added to slow down and demonstrate painting
            repaint();

            return null;
        }
    }
}