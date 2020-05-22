import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class AWG_Widget2 extends JPanel {
    public static final int MAP_WIDTH = 300;
    public static final int MAP_HEIGHT = 300;
    private static final String DEFAULT_GOOGLE_MAP_TEXT = "https://maps.googleapis.com/maps/"
            + "api/staticmap?center=10,-11.998672&zoom=6&size=612x612&scale=5&maptype=";
    private Icon defaultIcon = new ImageIcon(
            new BufferedImage(MAP_WIDTH, MAP_HEIGHT, BufferedImage.TYPE_INT_ARGB));
    private BorderLayout layout = new BorderLayout();
    private JPanel northPanel, centerPanel;
    private JButton bt_GetMap;

    // Holds the map
    private JLabel mapLabel = new JLabel(defaultIcon);

    // Combo Box for the types of maps: roadmap, satellite, terrain
    private String[] mapTypesStringArray = { "roadmap", "satellite", "terrain" };
    private String selectedMapType = "satellite";
    private JComboBox<MapType> mapTypesComboBox = new JComboBox<>(MapType.values());
    private String googleMapText = DEFAULT_GOOGLE_MAP_TEXT;

    public AWG_Widget2() {
        // Set layout
        setLayout(layout);
        // Sets a border around the pane
        this.setBorder(BorderFactory.createEtchedBorder());
        // inits panels
        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(mapLabel);
        // Creates components
        try {
            createMap(MapType.ROADMAP);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        bt_GetMap = new JButton("Get Map!");

        northPanel.add(mapTypesComboBox);
        northPanel.add(bt_GetMap);
        // Add panels to layout
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        // Add Listeners
        mapTypesComboBox.addItemListener(new ComboBoxItemListener());
        bt_GetMap.addActionListener(new ButtonListener());
    }

    private void createMyMap() {
        mapLabel.setIcon(defaultIcon);
        try {
            createMap((MapType) mapTypesComboBox.getSelectedItem());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void createMap(MapType mapType) throws IOException {
        new SwingWorker<Icon, Void>() {
            @Override
            protected Icon doInBackground() throws Exception {
                // this code is all done within a background thread
                String imageUrl = googleMapText + mapType.getText();
                URL url = new URL(imageUrl);
                Image img = ImageIO.read(url);
                img = img.getScaledInstance(MAP_WIDTH, MAP_HEIGHT, Image.SCALE_SMOOTH);
                return new ImageIcon(img);
            }

            @Override
            protected void done() {
                try {
                    // this code is called on the Swing event thread
                    // get returns the Icon created in the doInBackground method
                    mapLabel.setIcon(get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            };
        }.execute(); // executes our worker
    }

    // Item Listener Class
    class ComboBoxItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                createMyMap();
            }
        }
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createMyMap();
        }
    }

    private static void createAndShowGui() {
        AWG_Widget2 mainPanel = new AWG_Widget2();

        JFrame frame = new JFrame("AWG_Widget");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}