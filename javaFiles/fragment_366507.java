class Bullet {
    private final List<Runnable> onExplode = ...
    public void onExplode(Runnable r) { onExplode.add(r); }

    public void doExplode() {
        //show some colours
        for (Runnable r : onExplode) r.run();
    }
}