Bullet rifleBullet = new Bullet(2f);
Weapon rifle = new Weapon(rifleBullet);

Bullet shotgunBullet = new Bullet(5f);
Weapon shotgun = new Weapon(shotgunBullet);

/* somewhere in update() */
shotgun.shoot();
rifle.shoot();