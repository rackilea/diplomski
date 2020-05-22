public class IconFactory {

    private static HashMap<ICON, Image> images = new HashMap<ICON, Image>();

    public enum ICON {
        BASCET_REMOVE, BASCET_PUT, SAVE, OPEN, ARROW_RIGHT, ARROW_LEFT, ARROW_UP, ARROW_DOWN, CLOCK, ANALOG_SIGNAL, DIGITAL_SIGNAL, REFRESH, GREEN_PLUS, NETWORK, OK, CANCEL, RIGHT_NAV2, LEFT_NAV2, PLAY, PAUSE, LIST_ADD, PAGE_FIND, SET_PARAM, DOWNLOAD, UPLOAD, LOG_FILE, WARNING, INFO, LOG_DIAG, DATA_TRANS, TREE, FILTER, SEARCH, PARAM, ERASE, RESETDEF, RESETDEF2, DEBUG_BUG, INTERNATIONAL, CLOSE, HLP_BOOK
    }

    public static Image getImage(ICON en) {

        if (!images.containsKey(en)) {
            switch (en) {
            case HLP_BOOK:
                images.put(en, new Image(IconFactory.class.getResourceAsStream("help_book.png"))); break;
            default:
                return null;
            }
        }
        return images.get(en);
    }
}