import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TableWithHtml {

    private int count = 0;
    private String[] columnNames = {"<html><b>Name</b></html>", "<html><b>1</b></html>", "<html><b>2</b></html>", ""
        + "<html><b>3</b></html>", "" + "<html><b>4</b></html>", ""
        + "<html><b>5</b></html>", "" + "<html><b>6</b></html>", ""
        + "<html><b>7</b></html>", "" + "<html><b>8</b></html>", ""
        + "<html><b>9</b></html>", "" + "<html><b>10</b></html>", ""
        + "<html><b>11</b></html>", "" + "<html><b>12</b></html>", ""
        + "<html><b>13</b></html>", "" + "<html><b>14</b></html>", ""
        + "<html><b>15</b></html>", "" + "<html><b>16</b></html>", ""
        + "<html><b>17</b></html>", "" + "<html><b>18</b></html>", ""
        + "<html><b>19</b></html>", "" + "<html><b>20</b></html>", ""
        + "<html><b>21</b></html>", "" + "<html><b>22</b></html>", ""
        + "<html><b>23</b></html>", "" + "<html><b>24</b></html>", ""
        + "<html><b>25</b></html>", "" + "<html><b>26</b></html>", ""
        + "<html><b>27</b></html>", "" + "<html><b>28</b></html>", ""
        + "<html><b>29</b></html>", "" + "<html><b>30</b></html>", ""
        + "<html><b>31</b></html>"};
    private String dataValues[][];

    public TableWithHtml() {
        JPanel gui = new JPanel(new BorderLayout());
        gui.setBorder(new EmptyBorder(2, 3, 2, 3));
        JDesktopPane dtp = new JDesktopPane();
        gui.add(dtp);
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Component c = (Component) e.getSource();
                JOptionPane.showInternalMessageDialog(c, "Message");
            }
        };
        for (int ii = 0; ii < 13; ii++) {
            try {
                dataValues = new String[10][32];
                int i = 0;
                for (i = 0; i < 5; i++) {
                    for (int j = 0; j < 32; j++) {
                        if (j == 0) {
                            dataValues[i][0] = "Manu Suseelan";
                        } else {
                            dataValues[i][j] = "<html><body style='background:green;color:green'>&nbsp;&nbsp;|||&nbsp;&nbsp;</center></html>";
                        }
                    }
                }
            } catch (Exception ex) {
                System.out.println("sql error:" + ex);
            }
            DefaultTableModel df = new DefaultTableModel();
            df.setDataVector(dataValues, columnNames);
            JTable table = new JTable();
            table.setModel(df);
            int index = 0;
            while (index < 32) {
                TableColumn a = table.getColumnModel().getColumn(index);
                a.setPreferredWidth(100);
                a.setResizable(false);
                index++;
            }
            JInternalFrame jif = new JInternalFrame();
            dtp.add(jif);
            jif.setResizable(true);
            jif.setLocation(new Point(ii * 30, ii * 20));
            jif.setSize(600, 150);
            jif.setVisible(true);
            JButton b = new JButton("Click me!");
            b.addActionListener(listener);
            jif.add(table, BorderLayout.CENTER);
            jif.add(b, BorderLayout.SOUTH);
        }
        gui.setPreferredSize(new Dimension(1000, 600));
        gui.setBackground(Color.WHITE);
        JFrame f = new JFrame("Demo");
        f.add(gui);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                TableWithHtml tableWithHtml = new TableWithHtml();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}