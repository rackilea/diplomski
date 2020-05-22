import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestFrame extends JFrame{

    public TestFrame(int size){
        JPanel content = new JPanel(new GridLayout(size, size));
        JPanel[] panel = new JPanel[size * size];
        PanelListener listener = new PanelListener();

        for(int i = 0; i < panel.length; i++){
            panel[i] = new JPanel();
            panel[i].setBackground(Color.white);
            panel[i].addMouseListener(listener);
            content.add(panel[i]);
        }

        this.add(content);
    }

    // MouseListener offers the method mouseClicked(MouseEvent e)
    private class PanelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {
                    /* source is the object that got clicked
                     * 
                     * If the source is actually a JPanel, 
                     * then will the object be parsed to JPanel 
                     * since we need the setBackground() method
                     */
            Object source = event.getSource();
            if(source instanceof JPanel){
                JPanel panelPressed = (JPanel) source;
                panelPressed.setBackground(Color.blue);
            }
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {}

        @Override
        public void mouseExited(MouseEvent arg0) {}

        @Override
        public void mousePressed(MouseEvent arg0) {}

        @Override
        public void mouseReleased(MouseEvent arg0) {}

    }

    public static void main(String[] args){
        TestFrame theGUI = new TestFrame(8);
        theGUI.setTitle("Grid");
        theGUI.setVisible(true);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setSize(400,400);

    }
}