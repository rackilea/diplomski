public class menubar extends JMenuBar {
    private JDesktopPane desktop;

    JMenu Dosya;
    JMenuItem DosyaItem;

    menubar (JDesktopPane desktop) {
        this.desktop = desktop;
        Dosya = new JMenu("Dosya");