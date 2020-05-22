Iterator<Bullet> iterator = bulletList.iterator();
while (iterator.hasNext()) {
    Bullet iBullet = iterator.next();
    iBullet.move();
    iBullet.attack(bulletList, iterator);
}

public void attack(ArrayList<Bullet> bulletList, Iterator<Bullet> iterator) {
    iterator.remove();
}