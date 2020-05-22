import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class TableFun extends JPanel {
    private static final String IMG_PATH = "https://upload.wikimedia.org/"
            + "wikipedia/commons/d/d1/Ozanne-Brest.jpg";
    private JTable table = new JTable();
    private BufferedImage img;

    public TableFun(BufferedImage img, TableModel model) {
        this.img = img;
        table = new JTable(model);
        table.setDefaultRenderer(Object.class, new MyCellRenderer());
        table.setOpaque(false);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setShowGrid(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension superSize = super.getPreferredSize();
        if (isPreferredSizeSet() || img == null) {
            return superSize;
        }
        int supW = superSize.width;
        int supH = superSize.height;
        int imgW = img.getWidth();
        int imgH = img.getHeight();
        int w = Math.max(imgW, supW);
        int h = Math.max(imgH, supH);
        return new Dimension(w, h);
    }

    private class MyCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column != 0) {
                renderer.setHorizontalAlignment(JLabel.CENTER);
            } else {
                renderer.setHorizontalAlignment(JLabel.LEADING);
            }
            renderer.setOpaque(value != null);
            return renderer;
        }
    }

    private static void createAndShowGui() {
        BufferedImage img = null;
        try {
            URL imageUrl = new URL(IMG_PATH);
            img = ImageIO.read(imageUrl);
        } catch (IOException e1) {
            e1.printStackTrace();
            System.exit(-1);
        }
        String dataPath = "TableFunData.txt";
        DataIO dataIO = new DataIO(dataPath);
        TableModel model = null;
        try {
            model = dataIO.createTableModel();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JFrame frame = new JFrame("Table Fun");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TableFun(img, model));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class DataIO {

    private static final String NULL = "null";
    private String dataPath;

    public DataIO(String dataPath) {
        this.dataPath = dataPath;
    }

    public TableModel createTableModel() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(dataPath);
        Scanner scanner = new Scanner(inputStream);
        Vector<String> columnNames = new Vector<>();
        Vector<Vector<Object>> data = new Vector<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (columnNames.size() == 0) {
                columnNames = createColumnNames(line);
            } else {
                Vector<Object> dataRow = createDataRow(line);
                data.add(dataRow);
            }
        }
        if (scanner != null) {
            scanner.close();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }

    private Vector<String> createColumnNames(String line) {
        String[] tokens = line.split("\\s+");
        Vector<String> columnNames = new Vector<>();
        columnNames.add(" "); // first name is blank
        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                token = token.replace("_", " "); // add spaces
                columnNames.add(token);
            }
        }
        return columnNames;
    }

    private Vector<Object> createDataRow(String line) {
        String[] tokens = line.split("\\s+");
        Vector<Object> dataRow = new Vector<>();
        for (String token : tokens) {
            token = token.trim();
            if (!token.isEmpty()) {
                // first token is the title
                if (dataRow.size() == 0) {
                    token = token.replace("_", " "); // add spaces
                    dataRow.add(token);
                } else {
                    // if title already added
                    if (token.equalsIgnoreCase(NULL)) {
                        dataRow.add(null);
                    } else {
                        int value = Integer.parseInt(token);
                        dataRow.add(value);
                    }
                }
            }
        }
        return dataRow;
    }

}