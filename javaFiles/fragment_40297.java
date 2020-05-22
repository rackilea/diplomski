@Override
public void init() {

    smileyFace = new ImageIcon("images/happyFace.png");
    **add(new ImagePanel());**
    timerDelay = 10;
    timer = new Timer(timerDelay, new TimerListener());
    timer.start();

    //getContentPane().setBounds(0, 0, CONTENTPANE_WIDTH, CONTENTPANE_HEIGHT);
    getContentPane().setBackground(Color.BLACK);

    //maxY = getContentPane().getHeight();
    minY = 0;

    xCoord = 0;
    yCoord = 0;
    move = 2;

}