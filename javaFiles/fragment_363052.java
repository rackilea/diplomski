public class TestBouncingBall {

    private Rectangle insect;

    public static void main(String[] args) {
        new TestBouncingBall();
    }

    public TestBouncingBall() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new BallPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BallPane extends JLayeredPane {

        private Ball ball;
        private Timer timer;
        private Rectangle world;

        public BallPane() {

//            world = new Rectangle(random(400), random(400), random(100), random(100));
            world = new Rectangle(100, 100, 200, 200);

            ball = new Ball();
            ball.setSize(ball.getPreferredSize());
            ball.setLocation(10, 10);

            add(ball);

            timer = new Timer(16, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ball.move(getBounds(), world);
                    invalidate();
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();

        }

        protected int random(int max) {

            return (int) Math.round(Math.random() * max);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.GRAY);
            g2d.fill(world);
            if (insect != null) {
                g2d.setColor(Color.RED);
                g2d.fill(insect);
            }
            g2d.dispose();
        }
    }

    public class Ball extends JPanel {

        public int maxSpeed = 10;
        private BufferedImage beachBall;
        private int dx = 10 - (int)Math.round(Math.random() * (maxSpeed * 2)) + 1;
        private int dy = 10 - (int)Math.round(Math.random() * (maxSpeed * 2)) + 1;
        private int spin = 20;
        private int rotation = 0;

        public Ball() {
            try {
                beachBall = ImageIO.read(getClass().getResource("/ball.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setOpaque(false);
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = beachBall == null ? new Dimension(48, 48) : new Dimension(beachBall.getWidth(), beachBall.getHeight());
            size.width += 4;
            size.height += 4;
            return size;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (beachBall != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
                g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

                int x = (getWidth() - beachBall.getWidth()) / 2;
                int y = (getHeight() - beachBall.getHeight()) / 2;
                AffineTransform transform = g2d.getTransform();
                AffineTransform at = new AffineTransform();
                at.translate(getX(), getY());
                at.rotate(Math.toRadians(rotation), getWidth() / 2, getHeight() / 2);
                g2d.setTransform(at);
                g2d.drawImage(beachBall, x, y, this);
                g2d.setTransform(transform);
                g2d.dispose();
            }
        }

        public void move(Rectangle world, Rectangle collision) {
            Rectangle bounds = getBounds();
            bounds.x += dx;
            bounds.y += dy;

            if (bounds.x < 0) {
                bounds.x = 0;
                dx *= -1;
            }
            if (bounds.y < 0) {
                bounds.y = 0;
                dy *= -1;
            }
            if (bounds.x + bounds.width > world.width) {
                bounds.x = world.width - bounds.width;
                dx *= -1;
            }
            if (bounds.y + bounds.height > world.height) {
                bounds.y = world.height - bounds.height;
                dy *= -1;
            }

            if (collision.intersects(bounds)) {
                insect = collision.intersection(bounds);

                boolean vertical = false;
                boolean horizontal = false;
                boolean isLeft = false;
                boolean isTop = false;

                if (insect.x == collision.x) {
                    horizontal = true;
                    isLeft = true;
                } else if (insect.x + insect.width == collision.x + collision.width) {
                    horizontal = true;
                }
                if (insect.y == collision.y) {
                    vertical = true;
                    isTop = true;
                } else if (insect.y + insect.height == collision.y + collision.height) {
                    vertical = true;
                }

                if (horizontal && vertical) {
                    if (insect.width > insect.height) {
                        horizontal = false;
                    } else {
                        vertical = false;
                    }
                }

                System.out.println("v = " + vertical + "; h = " + horizontal);

                if (horizontal) {
                    dx *= -1;
                    if (isLeft) {
                        bounds.x = collision.x - bounds.width;
                    } else {
                        bounds.x = collision.x + collision.width;
                    }
                } else if (vertical) {
                    dy *= -1;
                    if (isTop) {
                        bounds.y = collision.y - bounds.height;
                    } else {
                        bounds.y = collision.y + collision.height;
                    }
                }

            }

            rotation += spin;

            setBounds(bounds);
            repaint();

        }
    }
}