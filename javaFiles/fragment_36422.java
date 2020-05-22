public class browserScreen extends MainScreen
{
    String url;

    public browserScreen() {


        url = "http://a1408.g.akamai.net/5/1408/1388/2005110405/1a1a1ad948be278cff2d96046ad90768d848b41947aa1986/sample_mpeg4.mp4";

        BrowserSession browserSession = Browser.getDefaultSession();

        browserSession.displayPage(url);
        browserSession.showBrowser();

        new keypress();



    }
}
class keypress extends Thread
{
    public keypress() {
        try {
            sleep(1000);
            start();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void run() {
        System.out.println("===================================click on enter");
         KeyEvent press= new EventInjector.KeyEvent(EventInjector.KeyEvent.KEY_DOWN, (char) (Keypad.KEY_ENTER), KeypadListener.STATUS_NOT_FROM_KEYPAD);
            EventInjector.invokeEvent(press);
    }
}