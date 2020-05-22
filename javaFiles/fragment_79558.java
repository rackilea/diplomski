import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            makeDatabase();
            populateDatabase();
            new Main();
        } catch (ClassNotFoundException | SQLException | IOException exp) {
            exp.printStackTrace();
        }
    }

    protected static Connection makeConnection() throws SQLException {
        String path = "jdbc:h2:./TestDatabase";
        return DriverManager.getConnection(path, "sa", "");
    }

    protected static void makeDatabase() throws SQLException {
        String cmd = "create table if not exists fruits ("
                + "key BIGINT IDENTITY, "
                + "name varchar(128), "
                + "image longblob)";
        try (Connection con = makeConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(cmd)) {
                System.out.println("> Make fruits table");
                stmt.executeUpdate();
            }
        }
    }

    protected static void populateDatabase() throws SQLException, IOException {
        removeAlFruits();
        insert("Apple", ImageIO.read(new File("Apple.png")));
        insert("Banana", ImageIO.read(new File("Banana.png")));
        insert("Cherries", ImageIO.read(new File("Cherries.png")));
        insert("Grapes", ImageIO.read(new File("Grapes.png")));
        insert("Orange", ImageIO.read(new File("Orange.png")));
        insert("Pear", ImageIO.read(new File("Pear.png")));
        insert("Pine Apple", ImageIO.read(new File("PineApple.png")));
        insert("Strewberry", ImageIO.read(new File("Strewberry.png")));
        insert("Water Melon", ImageIO.read(new File("WaterMelon.png")));
    }

    protected static void insert(String name, BufferedImage image) throws SQLException, IOException {
        String cmd = "insert into fruits (name, image) values (?, ?)";
        try (Connection con = makeConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(cmd)) {
                try (InputStream is = convertImageToInputStream(image)) {
                    System.out.println("> Insert " + name);
                    stmt.setString(1, name);
                    stmt.setBinaryStream(2, is);
                    int rows = stmt.executeUpdate();
                    System.out.println("> " + rows + " rows updated");
                }
            }
        }
    }

    protected static InputStream convertImageToInputStream(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = null;
        ByteArrayInputStream bais = null;
        try {
            baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.close();
            bais = new ByteArrayInputStream(baos.toByteArray());
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException ex) {
                }
            }
        }
        return bais;
    }

    protected static void removeAlFruits() throws SQLException {
        String cmd = "delete from fruits";
        try (Connection con = makeConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(cmd)) {
                System.out.println("> Remove all fruits");
                int rows = stmt.executeUpdate();
                System.out.println("> " + rows + " rows updated");
            }
        }
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new TestPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (SQLException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() throws SQLException, IOException {
            setLayout(new BorderLayout());
            DefaultTableModel model = makeTableModel();
            JTable table = new JTable(model);
            table.setRowHeight(100);
            add(new JScrollPane(table));
        }

        protected DefaultTableModel makeTableModel() throws SQLException, IOException {
            DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "Image"}, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnIndex == 1 ? Icon.class : super.getColumnClass(columnIndex);
                }

            };
            String cmd = "select name, image from fruits";
            try (Connection con = makeConnection()) {
                try (PreparedStatement stmt = con.prepareStatement(cmd)) {
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            String name = rs.getString(1);
                            Blob blob = rs.getBlob(2);
                            ImageIcon icon = null;
                            try (InputStream is = blob.getBinaryStream()) {
                                BufferedImage img = ImageIO.read(is);
                                icon = new ImageIcon(img);
                            }
                            model.addRow(new Object[]{name, icon});
                        }
                    }
                }
            }
            return model;
        }

    }
}