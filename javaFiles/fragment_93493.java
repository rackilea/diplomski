import java.awt.AWTEvent;
    import java.awt.Toolkit;
    import java.awt.event.AWTEventListener;
    import java.awt.event.ActionEvent;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import javax.swing.AbstractAction;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JMenu;
    import javax.swing.JPanel;
    import javax.swing.JPopupMenu;
    import javax.swing.SwingUtilities;

    public class DisableClickWhenPopupVisibleTest
    {
        public static void main(String[] args)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {               
                    final JPopupMenu popup = new JPopupMenu();
                    popup.add(new JMenu("aAaa"));
                    JPanel contentPane = new JPanel();
                    contentPane.add(popup);
                    JButton b = new JButton();
                    b.setAction(new AbstractAction("Button")
                    {
                        private static final long serialVersionUID = 1L;
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            System.out.println("b actionPerformed");
                        }
                    });
                    contentPane.add(b);
                    contentPane.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e)
                        {
                            showPopup(e);
                        }
                        @Override
                        public void mouseReleased(MouseEvent e)
                        {
                            showPopup(e);
                        }
                        private void showPopup(MouseEvent e)
                        {
                            if(e.isPopupTrigger())
                                popup.show(e.getComponent(), e.getX(), e.getY());
                        }
                    });
                    //use global mouse event capture to disable left click on anything when popup is visible
                    Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
                        @Override
                        public void eventDispatched(AWTEvent event)
                        {
                            MouseEvent me = (MouseEvent)event;
                            if(me.getID() == MouseEvent.MOUSE_PRESSED)
                            {
                                System.out.println("eventDispatched popup.vis="+popup.isVisible());
                                if( me.getButton() == MouseEvent.BUTTON3)
                                {   
                                    System.out.println("BUTTON3");
                                }   
                                else if(me.getButton() == MouseEvent.BUTTON1)
                                {
                                    System.out.println("BUTTON1");
                                    if(popup.isVisible())
                                        me.consume();
                                }
                            }
                        }
                    }, AWTEvent.MOUSE_EVENT_MASK);                      
                    JFrame f = new JFrame();
                    f.setContentPane(contentPane);
                    f.setSize(400, 300);
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setVisible(true);
                }
            });
        }
    }