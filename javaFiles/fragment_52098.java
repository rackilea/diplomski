public class MiniPad extends JFrame {

    //whatever code you have

    private static MiniPad padInstance = null; //the singleton instance of your MiniPad

    public static MiniPad pad() {
        if(padInstance == null)
            padInstance = new MiniPad();
        //If you want to reset the object every time you call the method for whatever reason, do it here
        pad.setVisible(true); // I believe this is all you want to do
    }
}