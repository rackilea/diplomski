public class MainMenu extends JPanel {

    Screen screen;
    //...

    public MainMenu(Screen srn) {

        this.screen = srn;
        //...
        if (screen.getKingdomcraft().inMainMenu) {