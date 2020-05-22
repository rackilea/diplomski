public class Gun{
    public void Shot(){
        // shoot code
    }

    public void RenderGun()
    {
        // render code
    }

    // more methods
}


public class GameManager
{
    Gun gun;

    public GameManager(Gun gun)
    {
        this.gun =gun;
    }

    // methods using GunClass methods.
}

public class HudScreen
{   
    public HudScreen()
    {
    }

    public void GunShotButton(Gun gun)
    {
        gun.Shoot();
    }
}