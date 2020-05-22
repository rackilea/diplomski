void update()
{
    // array for bullets which ar still in window
    ArrayList<Bullet> bulletsInWindow = new ArrayList<Bullet>();

    for( int i = 0; i < bullets.size(); ++i ) {
        Bullet b = bullets.get(i);

        // move bullet
        b.update();

        // evaluate eif bullet is still in window
        if ( b.x >= 0 && b.y >= 0 && b.x <= width && b.y <= height ) {
            bulletsInWindow.add(b);
        }
    }

    // keep the bullets which are still in the window
    bullets = bulletsInWindow;
}