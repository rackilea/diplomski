public class Gun {
    private ArrayList<Bullet> bullets;

    public void shoot(){
        load(new Bullet());
    }

    protected void load(Bullet bullet) {
        bullets.add(bullet);
    }
}

public class CustomGun extends Gun {
    @Override
    public void shoot() {
        load(new CustomBullet());
    }
}