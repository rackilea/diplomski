public class Test {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                final JFrame jf = new JFrame();
                jf.setSize(800, 600);
                jf.setTitle("Test");
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.getContentPane().setLayout(new BorderLayout());
                final int px = 200;
                final int py = 200;
                final int delta  = 10;
                final JPanel panel = new JPanel(){
                    @Override
                    protected void paintComponent(final java.awt.Graphics g) {
                        super.paintComponent(g);
                        final Color c = g.getColor();
                        g.setColor(Color.yellow);
                        g.fillOval(px - delta/2, py - delta/2, delta, delta);
                        g.setColor(c);
                    }
                };
                panel.setBackground(Color.red);

                panel.addMouseMotionListener(new MouseAdapter() {
                    @Override
                    public void mouseMoved(final MouseEvent e) {
                        final int x = e.getX();
                        final int y = e.getY();
                        if (Math.abs(x - px) < delta && Math.abs(y - py) < delta){
                            panel.setToolTipText("Point!");
                        }else{
                            panel.setToolTipText("Outside");
                        }
                    }
                });

                jf.getContentPane().add(panel, BorderLayout.CENTER);
                jf.setVisible(true);
            }
        });
    }
}