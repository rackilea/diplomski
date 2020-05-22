import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;

class GridLines {

    private JFrame frame;

    class MyGridPanel extends JPanel {
        private static final int ROWS = 4;
        private static final int COLS = 5;

        class CellPanel extends JPanel {
            int x;
            int y;

            public CellPanel(final int x, final int y) {
                setOpaque(false);
                this.x = x;
                this.y = y;
                MouseListener mouseListener = new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JOptionPane.showMessageDialog(CellPanel.this, "You pressed the cell with coordinates: x=" + x + " y=" + y);
                    }
                };
                setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
                addMouseListener(mouseListener);
            }

        }

        private final ImageIcon image;

        public MyGridPanel(ImageIcon imageIcon) {
            super(new GridLayout(ROWS, COLS));
            this.image = imageIcon;
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    add(new CellPanel(i, j));
                }
            }
            // Call to setPreferredSize must be made carefully. This case is a good reason.
            setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image.getImage(), 0, 0, this);
        }
    }

    protected void initUI() {
        frame = new JFrame(GridLines.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        File file = selectImageFile();
        if (file != null) {
            ImageIcon selectedImage = new ImageIcon(file.getAbsolutePath());
            frame.add(new MyGridPanel(selectedImage));
            frame.pack();
            frame.setVisible(true);
        } else {
            System.exit(0);
        }
    }

    public File selectImageFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return "Images files (GIF, PNG, JPEG)";
            }

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String fileName = f.getName().toLowerCase();
                return fileName.endsWith("gif") || fileName.endsWith("png") || fileName.endsWith("jpg") || fileName.endsWith("jpeg");
            }
        });
        int retval = fileChooser.showOpenDialog(frame);
        if (retval == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null; // Cancelled or closed
    }

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                new GridLines().initUI();
            }
        });
    }
}