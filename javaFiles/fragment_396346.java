class F extends JPanel implements MouseListener{
    /**
     * 
     */
    private static final int TIMER_DELAY = 35;
    private static final long serialVersionUID = -4926251405849574401L;
    public BufferedImage attic,flashlight,player,killer,frontpage,transition;
    public boolean onFrontPage,up,down,left,right,inAttic,onTransition;
    public int px,py,kx,ky;
    public static Thread th1,th2;
    public JFrame frame = new JFrame("Forgotten");
    public F(){
        init();
    }
    public void init(){
        setSize(1200,800);
        setVisible(true);
        onFrontPage = true;
        px = 600;
        py = 400;
        frame.add(this);
        frame.setSize(1200,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.addMouseListener(this);
        try{    
//            player = ImageIO.read(new File("char.png"));
//            flashlight = ImageIO.read(new File("flashlightimage.png"));
//            attic = ImageIO.read(new File("attic.png"));
//            killer = ImageIO.read(new File("killer.png"));
            attic = ImageIO.read(new File(...));
            frontpage = ImageIO.read(new File(...));
            transition = ImageIO.read(new File(...));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int fx = px - 1033;
        int fy = py - 635;
        kx = 500;
        ky = 500;
        // Removes the flickering of the images
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Resets the screen to make sure that it only shows the character once
        g2.clearRect(0, 0, 1200, 800);
        // Draws the background attic
        if(inAttic == true){
            System.out.println("Drawing attic"+System.currentTimeMillis());
            g2.drawImage(attic,0,0,this);
        }
        if(onFrontPage == true){
            g2.drawImage(frontpage, 0, 0, this);
        } 
        // Draws the player
        if(onFrontPage == false && onTransition == false){
            g2.drawImage(player, px, py, this);
            // Draws the Serial Killer
            g2.drawImage(killer, kx, ky, this);
            // Draws the flashlight
            g2.drawImage(flashlight, fx, fy, this);
        }
        if(onTransition == true){
            Graphics gt=transition.getGraphics();
            gt.setColor(Color.red);
            gt.drawString("xxx"+System.currentTimeMillis(), 10, 100);
            g2.drawImage(transition, 0, 0, this);
            onTransition = false;
            inAttic = true;
        }
        System.out.println(px + " " + py);
    }
    public void gameLoop(){

    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("MouseLocation: " + arg0.getX() + ", " + arg0.getY());
    }
    @Override
    public void mouseEntered(MouseEvent arg0) {

    }
    @Override
    public void mouseExited(MouseEvent arg0) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
            onFrontPage = false;
            onTransition = true;

    Thread th=new Thread() {
      public void run() {
            repaint();
             System.out.println("Drawing Transition"+System.currentTimeMillis());
            try {
                System.out.println("Sleeping for 5 Seconds"+System.currentTimeMillis());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Done sleeping."+System.currentTimeMillis());
            repaint();
      }
    };
    th.start();


    }
    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

}