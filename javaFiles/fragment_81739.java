public class MyProgram {
    JFrame frame;
    public MyProgram() {
        ...
        frame = new JFrame();
        JMenuBar mainMenu = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("Open..."));
        mainMenu.add(fileMenu); // adds a single JMenu to the menubar
        frame.setJMenuBar(mainMenu); // adds the entire menubar to the window
        ...
        frame.setVisible();
        ...
    }