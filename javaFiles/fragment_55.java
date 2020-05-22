public class MyTrayIcon extends TrayIcon {

    private static final String IMAGE_PATH = "/path/icon_16x16.png";
    private static final String TOOLTIP = "Text";

    private PopupMenu popup;
    private SystemTray tray;

    public MyTrayIcon(){
        super(createImage(IMAGE_PATH,TOOLTIP),TOOLTIP);
        popup = new PopupMenu();
        tray = SystemTray.getSystemTray();
    }

    @PostConstruct
    private void setup() throws AWTException{
        setPopupMenu(popup);
        tray.add(this);
    }

    protected static Image createImage(String path, String description){
        URL imageURL = MyTrayIcon.class.getResource(path);
        if(imageURL == null){
            System.err.println("Failed Creating Image. Resource not found: "+path);
            return null;
        }else {
            return new ImageIcon(imageURL,description).getImage();
        }
    }
}