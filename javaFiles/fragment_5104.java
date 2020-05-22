public class MenuBar {
private static JMenu[] menu = {new JMenu("Edit"), new JMenu("View") };

public static JMenuBar create() {
    JMenuBar menuBar = new JMenuBar();
    for (JMenu m : menu) {
        menuBar.add(m);
    }
    return menuBar
}