public void fire(final Player p, final Gun g) {
    for(int i=0; i<shotsPerBurst; i++) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                for(int i=0; i<bulletsPerShot; i++) {
                    Bullet b = new Bullet(p, g);
                    GunsV1.bullets.add(b);
                }
            }
        }, i*3);
    }
}