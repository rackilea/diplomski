ArrayList<Bullet> bullets = new ArrayList<Bullet>();

float ang = 0.7;
void keyPressed()
{
    switch (keyCode)
    {
        case RIGHT:
            ang += 0.1;
            break;
        case LEFT:
            ang -= 0.1;
            break;
        case 32:
            bullets.add(new Bullet(width/2, height/2, 2, ang));
            break;
    }
}