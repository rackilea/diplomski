public class DeckOfCards extends Applet {

    public void init() {

       Image[] clubs = new Image[13];
       for (int i = 0; i < clubs.length; i++ ) {
            clubs[i] = getImage( getDocumentBase(), "c" + (i + 1) + ".gif");
        }
        ...
    }
}