public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = " Game Name ";
        cfg.vSyncEnabled = true;
        cfg.width = 900;  < ---- here your game window width  will be set the firs time 
        cfg.height = 600;  < --- here yout game window height will be set for the first time 

        new LwjglApplication(new MainGame(), cfg);
    }
}