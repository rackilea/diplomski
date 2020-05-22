private BufferedImage player_left;
private BufferedImage player_right;

public Guy() { // Your consturctor:
    player_left = ImageIO.read(new File("resources/img/player-left.png"));
    player_right = ImageIO.read(new Fiel("resources/img/player-right.png"));
}

public void draw(Graphics g)
{
    if (direction == -1) { // left
        g.draw(player_left, .......);
    } else if (direction == 1) // right
    {
        g.draw(player_right, ......);
    } else if (direction == ...)
    {
        .....
    }
}