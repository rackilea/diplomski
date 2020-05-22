public class Window extends Frame{

    public Window(int width, int height, int locationX, int locationY) {
        setSize(width, height);
        setLocation(locationX, locationY);
        setResizable(false);
        setTitle("Window");
        setVisible(true);
    }
    public Window(int width, int height, int locationX, int locationY, String title){
        this(width, height, locationX, locationY);
        setTitle(title);
    }
    public Window(int width, int height, int locationX, int locationY, String title, Canvas c){
        this(witdth, height, locationX, locationY, title);
        add(c);
    }

}