public class Head 
    extends JPanel 
    implements MouseListener {

    //...all your other declarations still go here
    boolean isClosed = false;

    //also declare new 'eyes' which are closed

    public Head() {
        //..all your existing code is still here
        //add code to instantiate closed eyes

        //need to register a new MouseListener 
        //since head itself is a MouseListener, we can pass this as the argument
        this.addMouseListener(this);
    }

    //...all your existing code still goes here

    public void paintComponent(Graphics g) {
        //...all your existing code still goes here

        //decide which eyes to draw depending on isClosed
        if(isClosed) {
            //draw closed eyes
        }
        else {
            //draw open eyes
        }
        //draw everything else as before
    }

    //implementation for MouseListener
    //don't forget the rest of the MouseListener events
    //mousePressed, mouseReleased, mouseEntered, mouseExited
    public void mouseClicked(MouseEvent e) {
        //toggle the value of isClosed
        isClosed = !isClosed;

        //must repaint
        repaint();
    }