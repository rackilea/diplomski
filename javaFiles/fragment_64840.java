import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class StartDemo {

    private JFrame frame;
    private JPanel cards = new JPanel(new CardLayout());
    JMenuBar menuBar;
    JMenu mnNewMenu;
    JMenuItem mntmBookingStatus;
    JMenuItem mntmInvoiceEntry;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new StartDemo().initialize();
            }
        });
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 772, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // main menu
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // mainmenuoption-1
        mnNewMenu = new JMenu("Entries");
        menuBar.add(mnNewMenu);

        // option-1 items
        mntmBookingStatus = new JMenuItem("Booking Status");
        mnNewMenu.add(mntmBookingStatus);
        mntmBookingStatus.addActionListener(new MenuListenerAdapter());

        //StartDemo demo = new StartDemo();
        addComponentToPane(frame.getContentPane()); mntmInvoiceEntry = new JMenuItem("Invoice Entry");
        mnNewMenu.add(mntmInvoiceEntry);
        mntmInvoiceEntry.addActionListener(new MenuListenerAdapter());

        frame.setVisible(true);

    }

    public void addComponentToPane(Container pane) {
        JPanel booking_status = new JPanel();
        JPanel invoice_entry = new JPanel();
        //JPanel customer_ledger = new JPanel();
        //JPanel create_user = new JPanel();

        try {

            JPanelWithBackground panelWithBackground = new JPanelWithBackground(
                    "/resources/stackoverflow5.png");
            cards.add(panelWithBackground, "name_282751308799");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cards.add(booking_status, "booking");
        cards.add(invoice_entry, "invoice");
        //cards.add(customer_ledger, CUSTOMERLEDGER);
        //cards.add(create_user, CREATEUSER);

        pane.add(cards, BorderLayout.CENTER);

    }


    class JPanelWithBackground extends JPanel {
        Image img; 
        public JPanelWithBackground(String path) throws IOException {
            img = ImageIO.read(getClass().getResource(path));
        }

        @Override 
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }
    }

    public class MenuListenerAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            CardLayout c = (CardLayout) (cards.getLayout());

            if (e.getSource() == mntmBookingStatus) {
                c.show(cards,"booking");
                System.out.println(mntmBookingStatus);

            } else if (e.getSource() == mntmInvoiceEntry) {
                c.show(cards, "invoice");
                System.out.println(mntmInvoiceEntry);

            }

        }
    }
}