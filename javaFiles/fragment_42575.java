public class Tank extends JPanel implements ActionListener{
private int xTank=0,   
            yTank=0,
            xTankMotion=0,
            yTankMotion=0;
private int xAlien=800,
            yAlien=0,
            xAlienMotion=0,
            yAlienMotion=0;
private Image tank=new ImageIcon("Tank.jpg").getImage(),
              alien= new ImageIcon("Alien.jpg").getImage();
private int tankWidth=tank.getWidth(this), 
            tankHeight=tank.getHeight(this);
private int fire=0,
            xRocket=0,
            yRocket=0,
            xRocketMotion=0,
            yRocketMotion=0;
private int alienWidth=alien.getWidth(this), 
            alienHeight=alien.getHeight(this);
private int key=1;
private Timer time=new Timer(1,this);
private int angle;
private int truot=0,trung=0;
private boolean banduoc=true;
private JFrame frame;
private InputMap im= getInputMap(WHEN_IN_FOCUSED_WINDOW);
private ActionMap am= getActionMap();
public Tank(JFrame frame){ 
    this.frame=frame;
    time.start();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "moveleft");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "moveup");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "moveright");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "movedown");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "release");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "release");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "release");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "release");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "fire");

    am.put("moveleft", new AbstractAction(){
        public void actionPerformed(ActionEvent e){
            key=1;   
            xTankMotion=-1;
            yTankMotion=0;
            angle=0;
        }
    });
    am.put("moveup", new AbstractAction(){
        public void actionPerformed(ActionEvent e){
            key=2;
            xTankMotion=0;
            yTankMotion=-1; 
            angle=90;
        }
    });
    am.put("moveright", new AbstractAction(){
        public void actionPerformed(ActionEvent e){
            key=3;  
            xTankMotion=1; 
            yTankMotion=0;
            angle=180;
        }
    });
    am.put("movedown", new AbstractAction(){
        public void actionPerformed(ActionEvent e){
            key= 4;  
            xTankMotion=0;
            yTankMotion=1; 
            angle=-90;
        }
    });
    am.put("release", new AbstractAction(){
        public void actionPerformed(ActionEvent e){
            xTankMotion=0;
            yTankMotion=0;
        }
    });
    am.put("fire", new AbstractAction(){
        public void actionPerformed(ActionEvent e){if(banduoc){
            fire=1; 
            if(key==1) {
                xRocket=xTank;
                yRocket=yTank+tankHeight/2;
                xRocketMotion=-2;
                yRocketMotion=0;
            }
            if(key==2) {
                xRocket=xTank+tankWidth/2;
                yRocket=yTank;
                yRocketMotion=-2;
                xRocketMotion=0;
            }
            if(key==3) {
                xRocket=xTank+tankWidth;
                yRocket=yTank+tankHeight/2;
                xRocketMotion=2;
                yRocketMotion=0;
            }
            if(key==4) {
                xRocket=xTank+tankWidth/2;
                yRocket=yTank+tankHeight;
                yRocketMotion=2;
                xRocketMotion=0;
        }
            banduoc=false;
        }}
    });

    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    requestFocusInWindow();

}
@Override
public void actionPerformed(ActionEvent e){

    if(xTank<=0) xTank=0;
    if(xTank>=400) xTank=400;
    if(yTank<=0) yTank=0;
    if(yTank>=600-tankHeight) yTank=600-tankHeight;

    if(truot==0){
    if(xAlien<=1200-alienWidth) {
        xAlienMotion=1; 
        yAlienMotion=0;}
    if(xAlien>=1200-alienWidth){ 
        xAlienMotion=0; 
        yAlienMotion=1;}
    if(yAlien>=600-alienHeight){ 
        xAlienMotion=-1; 
        yAlienMotion=0;}
    if(xAlien<=800&&yAlien>=0){ 
        xAlienMotion=0; 
        yAlienMotion=-1;}}
    else {
        if(trung==0&&((xTank<=xAlien+alienWidth&&xTank+tankWidth>=xAlien+alienWidth&&((yTank>=yAlien&&yTank<=yAlien+alienHeight)||(yTank+tankHeight>=yAlien&&yTank+tankHeight<=yAlien+alienHeight)))||
            (yTank<=yAlien+alienHeight&&yAlien+alienHeight<=yTank+tankHeight&&((xTank>=xAlien&&xTank<=xAlien+alienWidth)||(xTank+tankWidth>=xAlien&&xTank+tankWidth<=xAlien+alienWidth)))||
            (xTank+tankWidth>=xAlien&&xAlien>=xTank&&((yTank>=yAlien&&yTank<=yAlien+alienHeight)||(yTank+tankHeight>=yAlien&&yTank+tankHeight<=yAlien+alienHeight)))||
            (yTank+tankHeight<=yAlien&&yAlien>=yTank&&((xTank>=xAlien&&xTank<=xAlien+alienWidth)||(xTank+tankWidth>=xAlien&&xTank+tankWidth<=xAlien+alienWidth)))))
        {time.stop();  frame.setContentPane(new Defeated(frame)); frame.pack(); return;}
        else{
            if(yAlien>yTank){
                yAlienMotion=-1;
                if(xAlien>xTank) xAlienMotion=-1;
                else if(xAlien<xTank) xAlienMotion=1;
                else xAlienMotion=0;
            }
            else if(yAlien<yTank){
                yAlienMotion=1;
                if(xAlien>xTank) xAlienMotion=-1;
                else if(xAlien<xTank) xAlienMotion=1;
                else xAlienMotion=0;
            }
            else{
                yAlienMotion=0;
                if(xAlien>xTank) xAlienMotion=-1;
                else if(xAlien<xTank) xAlienMotion=1;
            }
        }
    }
    xTank+=xTankMotion;
    yTank+=yTankMotion;

    xRocket+=xRocketMotion;
    yRocket+=yRocketMotion;

    xAlien+=xAlienMotion;
    yAlien+=yAlienMotion;

    if((xRocket>=1200||xRocket<0||yRocket<0||yRocket>600)&&truot==0)  {truot=1; banduoc=true;}
    if(xRocket>=xAlien&&xRocket<=xAlien+alienWidth&&yRocket>=yAlien&&yRocket<=yAlien+alienHeight) {trung=1; frame.setContentPane(new Victory(frame));  frame.pack();}
    repaint();
}
@Override
public Dimension getPreferredSize(){
    return new Dimension(1200,600);
}
@Override
protected void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    AffineTransform at= AffineTransform.getTranslateInstance(xTank,yTank);
    at.rotate(Math.toRadians(angle),tankWidth/2,tankHeight/2);
    Graphics2D g2d=(Graphics2D) g;
    g2d.drawImage(tank,at,null);
    g.drawImage(alien, xAlien, yAlien, this);
    if(fire==1) {
        g.setFont(new Font("Monospaced",Font.BOLD,20));
        g.setColor(Color.yellow);
        g.fillOval(xRocket,yRocket, 5, 5);
    }
    if(truot==1) {
        g.setColor(Color.red);
        g.drawString("Noooooo! :(", xTank, yTank-50);
    }
}
public static void main(String[] args) {
    JFrame frame=new JFrame("Tank");
    frame.setContentPane(new Menu(frame));
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setResizable(false);
}}