public class ControlPanel2 extends JPanel {
    private JButton basicTower, advanceTower, nextWave;
    private JLabel score, money;

    // note change 
    private int xPos; 
    private int yPos;

    private String action;

    public ControlPanel2() {
        setPreferredSize(new Dimension(150, GamePanel.HEIGHT));

        basicTower = new JButton("Basic Tower");
        basicTower.addActionListener(new ButtonListener("BasicTower"));
        this.add(basicTower);

        advanceTower = new JButton("Advance Tower");
        advanceTower.addActionListener(new ButtonListener("advanceTower"));
        add(advanceTower);

        nextWave = new JButton("Next Wave!");
        nextWave.addActionListener(new ButtonListener("nextWave"));
        add(nextWave);
        System.out.println("MADE IT");
        action = "none";

        // **** note changes. As an aside -- avoid "magic" numbers
        xPos = 100;
        yPos = 1000;

        score = new JLabel ("Score: " + x);
        money = new JLabel ("Money:  " + y);
        add(score);
        add(money);

    }

    public void setYPos(int z) {
        yPos -= z;
        money.setText("Money: " + yPos);
    }

    public void setXPos(int z) {
        xPos += z;
        score.setText("Score: " + xPos);
    }

    public int getYPos() {
        return yPos;
    }

    public int getXPos() {
        return xPos;
    }