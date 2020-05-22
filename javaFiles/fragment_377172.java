List<Bullet> bulletsToRemove = new ArrayList<Bullet>();
for (Bullet bullet : bullets) {
    bullet.draw(batch);
    bullet.update(Gdx.graphics.getDeltaTime());
    if (bullet.position.y <= 0)
        bulletsToRemove.add(bullet);
}
bullets.removeAll(bulletsToRemove);