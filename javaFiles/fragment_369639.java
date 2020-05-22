class CustomPopup extends JPopupMenu {
    public CustomPopup() {}

    @Override
    public void setVisible(boolean visible)
    {
        // Case 1:
        if (visible) super.setVisible(visible);
        // Case 2:
//        super.setVisible(visible);
    }
    public void makeInvisible() {
        super.setVisible(false);
    }
}

class CustomPanel extends JPanel {
    // .../...
    public CustomPanel() {
        setSize(200, 200);
        addMouseListener( new MouseAdapter(){
            @Override
            public void mousePressed( MouseEvent e ){
                onMousePressed( e );
            }
        });

    }

    public void onMousePressed( MouseEvent e )
    {
        JPopupMenu pop = new JPopupMenu();

        pop.add( new AbstractAction( "foo" )
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                // do stuff
                System.out.println("this is executed");
                Component comp = (Component) e.getSource();
                if (comp != null && comp.getParent() instanceof JPopupMenu) {
                    JPopupMenu popupMenu = (JPopupMenu) comp.getParent();
                    if (popupMenu.getInvoker() instanceof CustomPanel) {
                        CustomPopup cpop = (CustomPopup) popupMenu.getInvoker().getParent();
                        cpop.makeInvisible();
                    }
                }
            }
        });
        pop.show( e.getComponent(), e.getX(), e.getY() );
    }
}

public class TestPopup extends JFrame {
    CustomPanel _pp;
    CustomPopup _cpop;

    public TestPopup () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(333, 333);
        _cpop = new CustomPopup();
        _pp = new CustomPanel();
        _cpop.add(_pp);

        addMouseListener( new MouseAdapter(){
            @Override
            public void mousePressed( MouseEvent e ){
                _cpop.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new TestPopup()).setVisible(true);
            }
        });
    }
}