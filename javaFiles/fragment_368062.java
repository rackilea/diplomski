public class Frame extends JFrame{

public static void main(String[] args) {
    Frame f = new Frame();
    Circle circle  = new Circle();
    Square square  = new Square();
    f.add(circle);
    f.add(square);
}

public Frame(){
    setTitle("Frame");
    setSize(500, 500);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}