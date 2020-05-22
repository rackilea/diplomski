class Board extends JPanel {
    public Player players[];
    private BufferedImage boardPic; // use a BufferedImage

    Board(Player[] players) {
        this.players = players;
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.WHITE);

        // much better to use resources and not files
        // you'll need to handle an exception here.
        boardPic = new ImageIO.read(new File("images/board.png"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(boardPic, 0, 0, this);

        int x = 0;
        int y = 0;
        for(Player i: this.players) {
            g.setColor(i.getColor());
            int position = i.getGamePosition();

            if(position == 0) {
                x = 25;
                y = 700;
            }  else if (position > 0 && position < 9)  {
                x = 25;
                y = ((10-position)*63)+31;
            }  else if (position == 9)  {
                x = 25;
                y = 25;
            } else if (position > 9 && position < 18) {
                y = 25;
                x = ((position-9)*63)+98;
            } else if(position == 18) {
                x = 750;
                y = 10;
            } else if(position > 18 && position < 27) {
                x = 745;
                y = ((position-18)*63)+95;
            } else if (position == 27) {
                x = 750;
                y = 660;
            } else if(position > 27) {
                x = ((20-position)*63)+1105; 
                y= 700;
            }
            g.fillRect(x, y, 40, 40);
        }
    }
}