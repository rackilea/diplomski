@SuppressWarnings("serial")
class BackgroundPanel2 extends JPanel {
    private Image backgroundImg;

    public BackgroundPanel2(Image backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImg != null) {
            g.drawImage(backgroundImg, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || backgroundImg == null) {
            return super.getPreferredSize();
        } else {
            int w = backgroundImg.getWidth(this);
            int h = backgroundImg.getHeight(this);
            return new Dimension(w, h);
        }
    }
}

@SuppressWarnings("serial")
class GamePanel2 extends JPanel {
    public static final int MAX_BUTTONS = 100;
    private static final int IMG_WIDTH = 40;
    JButton[] gameButtons = new JButton[MAX_BUTTONS];

    public GamePanel2(Image buttonImg) {
        setOpaque(false);
        if (buttonImg.getWidth(this) > IMG_WIDTH) {
            buttonImg = buttonImg.getScaledInstance(IMG_WIDTH, IMG_WIDTH, Image.SCALE_SMOOTH);
        }
        Icon icon = new ImageIcon(buttonImg);
        setLayout(new GridLayout(10, 10, 4, 4));
        for (int i = 0; i < gameButtons.length; i++) {
            int finalIndex = i;
            JButton btn = new JButton(icon);
            btn.addActionListener(e -> {
                String text = String.format("Button: %02d", finalIndex);
                System.out.println(text);
            });
            add(btn);
            gameButtons[i] = btn;            
        }
    }
}