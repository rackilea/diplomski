public class GUITest {

private static int windowWidth = 500;
private static int windowHeight = 500;

private static JFrame frame;
private static JMenuBar menuBar;

public static void main(String[] args){
    build();
}

private static void build(){
    windowGen();
    menuGen();
}

private static void windowGen(){
    frame = new JFrame();
    frame.setLayout(null);
    frame.setSize(windowWidth,windowHeight);
    frame.setVisible(true);
}

private static void menuGen(){
    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu("File");
    JMenuItem menuFileExit = new JMenuItem("Exit");
    menuFile.add(menuFileExit);

    menuBar.add(menuFile);

    frame.setJMenuBar(menuBar);
}   
}