public static void main(String[] args)
{
    SplashScreen splSplashScreen = new SplashScreen();
    //Main window
    FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
    worker w = new worker(splSplashScreen, fenetrePrincipale);
    w.execute();
}