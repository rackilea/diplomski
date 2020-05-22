import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DragDialog extends JDialog {

    private int pointX;
    private int pointY;

    public DragDialog() {
        JTextField textField = createTextField();
        setContentPane(createBackgroundPanel());
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createBackgroundPanel() {
        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(527, 527);
            }
        };
        panel.setOpaque(false);
        panel.setLayout(null);

        String[] filePaths = getFilePaths();
        Map<String, ImageIcon> imageMap = initImages(filePaths);
        Map<String, Rectangle> rectMap = createRectangles();

        for (Map.Entry<String, Rectangle> entry: rectMap.entrySet()) {
            JLabel label = new JLabel();
            label.setOpaque(false);
            String fullImageKey = entry.getKey() + "-default";
            ImageIcon icon = imageMap.get(fullImageKey);
            label.setIcon(icon);
            label.setBounds(entry.getValue());
            label.addMouseListener(new LabelMouseListener(entry.getKey(), imageMap));
            panel.add(label);
        }

        JLabel octagon = createOctagonLabel();
        octagon.setBounds(85, 85, 357, 357);
        panel.add(octagon);

        return panel;
    }



    private Map<String, Rectangle> createRectangles() {
        Map<String, Rectangle> rectMap = new HashMap<>();
        rectMap.put("north", new Rectangle(191, 0, 145, 73));
        rectMap.put("northwest", new Rectangle(74, 74, 103, 103));
        rectMap.put("northeast", new Rectangle(348, 74, 103, 103));
        rectMap.put("west", new Rectangle(0, 190, 73, 145));
        rectMap.put("east", new Rectangle(453, 190, 73, 145));
        rectMap.put("south", new Rectangle(190, 453, 145, 73));
        rectMap.put("southwest", new Rectangle(74, 348, 103, 103));
        rectMap.put("southeast", new Rectangle(349, 349, 103, 103));

        return rectMap;
    }

    private class LabelMouseListener extends MouseAdapter {
        private String position;
        private Map<String, ImageIcon> imageMap;

        public LabelMouseListener(String position, Map<String, ImageIcon> imageMap) {
            this.imageMap = imageMap;
            this.position = position;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println(position + " pressed");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JLabel label = (JLabel)e.getSource();
            String fullName = position + "-hovered";
            ImageIcon icon = imageMap.get(fullName);
            label.setIcon(icon);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel label = (JLabel)e.getSource();
            String fullName = position + "-default";
            ImageIcon icon = imageMap.get(fullName);
            label.setIcon(icon);
        }
    }

    private String[] getFilePaths() {
        String[] paths = { "north-default.png", "north-hovered.png",
                "northwest-default.png", "northwest-hovered.png",
                "northeast-default.png", "northeast-hovered.png",
                "west-default.png", "west-hovered.png", "east-default.png",
                "east-hovered.png", "south-default.png", "south-hovered.png",
                "southwest-default.png", "southwest-hovered.png",
                "southeast-default.png", "southeast-hovered.png"

        };
        return paths;
    }

    private Map<String, ImageIcon> initImages(String[] paths) {
        Map<String, ImageIcon> map = new HashMap<>();
        for (String path: paths) {
            ImageIcon icon = null;
            try {
                System.out.println(path);
                icon = new ImageIcon(ImageIO.read(getClass().getResource("/octagonframe/" + path)));
            } catch (IOException e) {

                e.printStackTrace();
            }
            String prefix = path.split("\\.")[0];
            map.put(prefix, icon);
        }
        return map;
    }

    private JTextField createTextField() {
        final JTextField field = new JTextField(20);
        field.setText("Type \"exit\" to terminate.");
        field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = field.getText();
                if ("exit".equalsIgnoreCase(text)) {
                    System.exit(0);
                }
            }
        });
        return field;
    }

    private JLabel createOctagonLabel() {
        Image image = null;
        try {
            image = ImageIO.read(getClass().getResource("/octagonframe/octagon.png"));
        } catch (IOException ex) {
            Logger.getLogger(DragDialog.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        JLabel label = new JLabel(new ImageIcon(image));
        label.setLayout(new GridBagLayout());
        label.add(createTextField());

        label.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                DragDialog.this.setLocation(
                        DragDialog.this.getLocation().x + e.getX() - pointX,
                        DragDialog.this.getLocation().y + e.getY() - pointY);
            }
        });
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pointX = e.getX();
                pointY = e.getY();
            }
        });

        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DragDialog();
            }
        });
    }
}