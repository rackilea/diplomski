public class MyClass implements MouseMotionListener {

    public void mouseMoved(MouseEvent e) {
       System.out.println("X : " + e.getX());
       System.out.println("Y : " + e.getY());
    }

    public void mouseDragged(MouseEvent e) {
       //do something
    }

}