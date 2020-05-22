public class MyWindow extends JFrame {

    MyPanel thePanel;

    public MyWindow(int x, int y) {
        setSize(x, y);
        thePanel = new MyPanel(x, y);
        this.add(thePanel);
    }

}

public class MyPanel extends JPanel {
    public MyPanel(int x, int y)
        setSize(x, y);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageManager.getImage("Cute Puppy"), 40, 40, null); // Or whatever
    }
}