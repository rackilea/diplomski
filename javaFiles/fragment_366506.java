class BoomState {
    private final List<Explosion> booms = new ArrayList<Explosion>();
    private final Set<Bullet> liveBullets = new HashSet<Bullet>();

    // to be called by your weapon or bullet factory
    public void addLiveBullet(final Bullet bullet) {
        liveBullets.add(bullet);
        bullet.onExplode(new Runnable() {
            @Override public void run() {
                addBoom();
                liveBullets.remove(bullet);
            }
        });
    }

    public void addBoom() {...}
    public List<Explosion> getBooms() {...}
}