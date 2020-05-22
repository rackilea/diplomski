public class menubar {
public static JMenuBar menuBar(){
    JMenuBar menu = new JMenuBar();
    JMenu file = new JMenu("File");
        JMenuItem clear = new JMenuItem("New");
        JMenuItem exit = new JMenuItem("Exit");
    JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        JMenuItem instructions = new JMenuItem("Instructions");
    return menu;
} // Ends method menuBar
} // Ends class menubar