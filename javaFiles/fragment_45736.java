import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class ShowImages {

    public static void main(String[] args) {
        new ShowImages();
    }

    public ShowImages() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final ImageTableModel model = new ImageTableModel();
                JTable table = new JTable(model);

                final JButton scan = new JButton("Scan");
                scan.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.clear();
                        scan.setEnabled(false);
                        ScanWorker worker = new ScanWorker(new File("C:\\Users\\shane\\Dropbox\\MegaTokyo"), model);
                        worker.addPropertyChangeListener(new PropertyChangeListener() {
                            @Override
                            public void propertyChange(PropertyChangeEvent evt) {
                                if ("state".equalsIgnoreCase(evt.getPropertyName())) {
                                    SwingWorker.StateValue state = (SwingWorker.StateValue) evt.getNewValue();
                                    scan.setEnabled(state == SwingWorker.StateValue.DONE);
                                    scan.setText("Scan");
                                } else if ("directory".equalsIgnoreCase(evt.getPropertyName())) {

                                    String text = ((File)evt.getNewValue()).getPath().replaceAll("shane", "...");
                                    text = text.replaceAll("C:\\\\", "...");
                                    text = text.replaceAll("Dropbox", "...");
                                    scan.setText(text);

                                }
                            }
                        });
                        worker.execute();
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.add(scan, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ImageProperty {

        private File source;
        private Dimension size;
        private boolean selected;

        public ImageProperty(File source, Dimension size, boolean selected) {
            this.source = source;
            this.size = size;
            this.selected = selected;
        }

        public Dimension getSize() {
            return size;
        }

        public File getSource() {
            return source;
        }

        public boolean isSelected() {
            return selected;
        }

    }

    public class ImageTableModel extends AbstractTableModel {

        private List<ImageProperty> images;

        public ImageTableModel() {
            images = new ArrayList<ImageProperty>(25);
        }

        @Override
        public int getRowCount() {
            return images.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int column) {
            String name = "";
            switch (column) {
                case 1:
                    name = "Path";
                    break;
                case 2:
                    name = "Name";
                    break;
                case 3:
                    name = "Size";
                    break;
            }
            return name;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnIndex == 0 ? Boolean.class : String.class;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ImageProperty row = images.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = row.isSelected();
                    break;
                case 1:
                    value = row.getSource().getParent();
                    break;
                case 2:
                    value = row.getSource().getName();
                    break;
                case 3:
                    value = row.getSize().width + "x" + row.getSize().height;
                    break;
            }
            return value;
        }

        public void addImage(ImageProperty image) {

            images.add(image);
            fireTableRowsInserted(images.size() - 1, images.size() - 1);

        }

        public void addImages(List<ImageProperty> newImages) {

            int firstRow = images.size();
            int lastRow = firstRow + newImages.size() - 1;

            images.addAll(newImages);
            fireTableRowsInserted(firstRow, lastRow);

        }

        public void clear() {

            int lastRow = images.size() -1;
            images.clear();
            fireTableRowsDeleted(0, lastRow);

        }

    }

    public class ScanWorker extends SwingWorker<Object, ImageProperty> {

        private File source;
        private ImageTableModel model;

        public ScanWorker(File source, ImageTableModel model) {
            this.source = source;
            this.model = model;
        }

        @Override
        protected void process(List<ImageProperty> chunks) {
            model.addImages(chunks);
        }

        @Override
        protected Object doInBackground() throws Exception {
            scan(source);
            return null;
        }

        protected void scan(File dir) {
            firePropertyChange("directory", dir.getParent(), dir);
            File pngs[] = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().toLowerCase().endsWith(".png");
                }
            });
            for (File png : pngs) {
                try {
                    BufferedImage img = ImageIO.read(png);
                    publish(new ImageProperty(png, new Dimension(img.getWidth(), img.getHeight()), false));
                } catch (IOException e) {
                    System.out.println("Bad image: " + png);
                    e.printStackTrace();
                }
            }
            File dirs[] = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory();
                }
            });
            if (dirs != null && dirs.length > 0) {
                for (File subDir : dirs) {
                    scan(subDir);
                }
            }
        }

    }

}