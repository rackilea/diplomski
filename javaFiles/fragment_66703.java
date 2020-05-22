public void fire() {
    angle = sprite.getRotation();
    System.out.println(angle);
    x = sprite.getX();
    y = sprite.getY();

    double bulletX = x + (gunOffsetX * Math.cos(angle) - gunOffsetY * Math.sin(angle);
    double bulletY = y + (gunOffsetX * Math.sin(angle) + gunOffsetY * Math.cos(angle);

    Bullet b = new Bullet(bulletX , bulletY , angle);
    Utils.world.addBullet(b);
}