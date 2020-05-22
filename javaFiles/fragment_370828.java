import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Test {

    public Test() throws Exception {
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Test();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void initComponents() throws Exception {

        createAndShowTray();

    }

    private void createAndShowTray() throws Exception {

        //Check the SystemTray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        PopupMenu popup = new PopupMenu();
        //retieve icon form url and scale it to 32 x 32
        final TrayIcon trayIcon = new TrayIcon(ImageIO.read(
                new URL("http://www.optical-illusions.in/illusions/blue_rotation_optical_illusion.jpg"))
                .getScaledInstance(32, 32, Image.SCALE_SMOOTH), null);

        //get the system tray
        final SystemTray tray = SystemTray.getSystemTray();

        // Create a pop-up menu components
        MenuItem aboutItem = new MenuItem("About");
        aboutItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "About");
            }
        });

        final  CheckboxMenuItem cb1 = new CheckboxMenuItem("Set tooltip");
        cb1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(cb1.getState()==true) {
                trayIcon.setToolTip("Hello, world");
                }else {
                trayIcon.setToolTip("");
                }
            }
        });

        Menu displayMenu = new Menu("Display");
        MenuItem infoItem = new MenuItem("Info");

        MenuItem exitItem = new MenuItem("Exit");
        //add actionlistner to exit menu item
        exitItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        //Add components to pop-up menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(cb1);
        popup.addSeparator();
        popup.add(displayMenu);
        displayMenu.add(infoItem);
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }
}