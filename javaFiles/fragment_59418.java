import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class SystemFontDisplayer {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame("Nimbus UIDeafaults and Font");
    private JComboBox fontsBox;
    private javax.swing.Timer timer = null;
    private JButton testButton = new JButton("testButton");
    private JTextField testTextField = new JTextField("testTextField", JLabel.CENTER);
    private JLabel testLabel = new JLabel("testLabel");
    private Font font1, font2;
    private JMenuBar menuBar1 = new JMenuBar();
    private JMenu menu1= new JMenu("Menu 1");
    private JMenu menu2= new JMenu("Menu 2");
    private JMenuItem menuItem1= new JMenuItem("MenuItem 1");
    private JMenuItem menuItem2= new JMenuItem("MenuItem 2");

    public SystemFontDisplayer() {
        try {
            font1 = Font.createFont(Font.TRUETYPE_FONT, SystemFontDisplayer.class.getResourceAsStream("/Images/SourceSansPro-Regular.ttf"));
            font2 = Font.createFont(Font.TRUETYPE_FONT, SystemFontDisplayer.class.getResourceAsStream("/Images/SourceSansPro-Regular.otf"));
        } catch (FontFormatException ex) {
            Logger.getLogger(SystemFontDisplayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SystemFontDisplayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //ge.registerFont(font1);
        ge.registerFont(font2);
        String[] fontFamilyNames = ge.getAvailableFontFamilyNames(Locale.getDefault());
        fontsBox = new JComboBox(fontFamilyNames);
        fontsBox.setSelectedItem(0);
        fontsBox.setRenderer(new ComboRenderer());
        fontsBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    final String fontName = fontsBox.getSelectedItem().toString();
                    fontsBox.setFont(new Font(fontName, Font.PLAIN, 16));
                    start();
                }
            }
        });
        fontsBox.setSelectedItem(0);
        fontsBox.getEditor().selectAll();

        menu1.add(menuItem1);
        menuBar1.add(menu1);
        menu2.add(menuItem2);
        menuBar1.add(menu2);
        frame.setJMenuBar(menuBar1);
        frame.setLayout(new GridLayout(4, 0, 5, 5));
        frame.add(fontsBox);
        frame.add(testButton);
        frame.add(testTextField);
        frame.add(testLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(200, 105);
        frame.pack();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                fontsBox.setPopupVisible(true);
                fontsBox.setPopupVisible(false);
            }
        });
        frame.setVisible(true);
    }

    private void start() {
        timer = new javax.swing.Timer(250, updateCol());
        timer.setRepeats(false);
        timer.start();
    }

    public Action updateCol() {
        return new AbstractAction("text load action") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                final Font fnt = new Font(fontsBox.getSelectedItem().toString(), Font.PLAIN, 16);
                try {
                    LookAndFeel lnf = UIManager.getLookAndFeel().getClass().newInstance();
                    final FontUIResource res = new FontUIResource(fnt);
                    UIDefaults uiDefaults = lnf.getDefaults();
                    uiDefaults.put("defaultFont", res);
                    UIManager.getLookAndFeel().uninitialize();
                    UIManager.setLookAndFeel(lnf);
                } catch (InstantiationException ex) {
                    Logger.getLogger(SystemFontDisplayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(SystemFontDisplayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(SystemFontDisplayer.class.getName()).log(Level.SEVERE, null, ex);
                }
                UIDefaults defaults = UIManager.getDefaults();
                final FontUIResource res = new FontUIResource(fnt);
                Object[] obj = res.getAvailableAttributes();
                for (Object objs : obj) {
                    System.out.println(objs); //returns java.awt.font.TextAttribute
                }
                defaults.put("defaultFont", res);
                SwingUtilities.updateComponentTreeUI(frame);
                frame.pack();
            }
        };
    }

    public static void main(String arg[]) {
        try {
            for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(laf.getName())) {
                    UIManager.setLookAndFeel(laf.getClassName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SystemFontDisplayer systemFontDisplayer = new SystemFontDisplayer();
            }
        });
    }

    private class ComboRenderer extends BasicComboBoxRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            final Object fntObj = value;
            final String fontFamilyName = (String) fntObj;
            setFont(new Font(fontFamilyName, Font.PLAIN, 16));
            return this;
        }
    }
}