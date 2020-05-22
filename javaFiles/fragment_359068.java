import java.awt.Color;
import java.awt.Component;
import static java.awt.Dialog.ModalityType.APPLICATION_MODAL;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.MessageFormat;
import javax.imageio.ImageIO;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PrintPreview extends JDialog implements ActionListener {

    public static void main(String[] args) {
        new PrintPreview(new int[]{1, 2, 3, 4}, null);
    }

    private JTable infoTable;

    private boolean printed;
    private int windowWidth;
    private int windowHeight;
    JPanel container;
//    JPanel scrollerPanel;
    JPanel dataPanel;

    private int[] idList;
    private Connection conn;

    private JScrollPane scroller;
    private JButton printButton;

    JTable printable;

    public PrintPreview(int[] tIds, Connection tConn) {
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        printed = false;

        idList = tIds;
        conn = tConn;

        setupFrame();
        setupScroller();
        setupButtons();

        this.setContentPane(container);
        this.pack();
        this.setVisible(true);
    }

//returns true if printed, false otherwise
    public boolean getCloseValue() {
        return printed;
    }

    private void setupFrame() {
        this.setTitle("Edit Data");
        this.setSize(800, 700); //Width, Height
        this.setLocationRelativeTo(null); //Centers the JFrame on the screen
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
//        this.setResizable(false);
        this.setModalityType(APPLICATION_MODAL);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Gets the size of the contentPanel of the frame
        Insets inset = this.getInsets();
        windowWidth = this.getSize().width - (inset.left + inset.right);
        windowHeight = this.getSize().height - (inset.top + inset.bottom);
    }

    private void setupScroller() {
//        scrollerPanel = new JPanel();

        scroller = new JScrollPane(setupTable());

//        scroller = new JScrollPane(setupTable(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

//        infoTable.setFillsViewportHeight(true);

//        scroller.setSize(windowWidth, windowHeight - 120);
//        scroller.setMinimumSize(new Dimension(windowWidth, windowHeight - 120));
//        scroller.setMaximumSize(new Dimension(windowWidth, windowHeight - 120));
//        scroller.setPreferredSize(new Dimension(windowWidth, windowHeight - 120));

//        scroller.setVisible(true);//*********************************************************
//        scroller.add(setupTable());
//        scrollerPanel.add(scroller);
//        scrollerPanel.setVisible(true);//******************************************************
//        scrollerPanel.setOpaque(true);//*************************************************************

        container.add(scroller);
    }

    private void setupButtons() {
        JPanel spacer1 = new JPanel();
        spacer1.setSize(100, 20);
        spacer1.setMaximumSize(new Dimension(100, 20));
        spacer1.setMinimumSize(new Dimension(100, 20));
        spacer1.setPreferredSize(new Dimension(100, 20));

        JPanel spacer2 = new JPanel();
        spacer2.setSize(100, 20);
        spacer2.setMaximumSize(new Dimension(100, 20));
        spacer2.setMinimumSize(new Dimension(100, 20));
        spacer2.setPreferredSize(new Dimension(100, 20));

        printButton = new JButton("Print");
        printButton.setFont((new Font("", Font.BOLD, 14)));
        printButton.setSize(new Dimension(130, 35));
        printButton.setMaximumSize(new Dimension(130, 35));
        printButton.setMinimumSize(new Dimension(130, 35));
        printButton.setPreferredSize(new Dimension(130, 35));
        printButton.addActionListener(this);

        spacer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        printButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        container.add(spacer1);
        container.add(printButton);
        container.add(spacer2);
    }

    private JTable setupTable() {
        infoTable = new JTable();

        DefaultTableModel dm = new DefaultTableModel(0, 0);
        String header[] = new String[]{"Case #", "Date", "Officer #", "Offence",
            "Description", "Report"};
        dm.setColumnIdentifiers(header);
        infoTable.setModel(dm);
        infoTable.setRowHeight(26);
        infoTable.setFocusable(false);//display only

        //Adds everything to the table
        int idSize = idList.length;
        for (int row = 0; row < 10; row++) {
            String value = Integer.toString(row);
            String[] values = new String[]{value, value, value, value, value, value};
            dm.addRow(values);
        }

//        for (int x = 0; x < idSize; x++) {
//            try {
//                String[] values = getInfo(idList[x]);
//                values[4] = values[4].trim();
//                values[4] = values[4].replaceAll("<html>", "");
//
//                dm.addRow(values);
//            } catch (SQLException e) {
//                System.out.println("Error: " + e);
//                System.out.println("Event-addObjects(): Problem with getting event info");
//            }
//
//            infoTable.setFont(new Font("Serif", Font.PLAIN, 10));
//        }
        //Centers the values on the smaller columns
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//        infoTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//        infoTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
//        infoTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
//        infoTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
//        infoTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
//
//        //Sets the sizes of the columns
//        infoTable.getColumnModel().getColumn(0).setMinWidth(40);
//        infoTable.getColumnModel().getColumn(1).setMinWidth(65);
//        infoTable.getColumnModel().getColumn(2).setMinWidth(40);
//        infoTable.getColumnModel().getColumn(3).setMinWidth(80);
//        infoTable.getColumnModel().getColumn(4).setMinWidth(250);
//        infoTable.getColumnModel().getColumn(5).setMinWidth(50);

        //Makes the Description column cells JTextFields
//        infoTable.getColumnModel().getColumn(4).setCellRenderer(new VariableRowHeightRenderer());
        //Looks at the size each JTextField would like to be and changes the rows to accomidate
//        int column = 4;
//        for (int row = 0; row < infoTable.getRowCount(); row++) {
//            int rowHeight = 26;
//
//            Component comp = infoTable.prepareRenderer(infoTable.getCellRenderer(row, column), row, column);
//            rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
//
//            if (rowHeight != infoTable.getRowHeight(row)) {
//                infoTable.setRowHeight(row, rowHeight);
//            }
//        }
//        infoTable.setVisible(true);//***********************************************************************
        return infoTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Print":
                printed = true;

                //Makes the margins smaller
                PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
                aset.add(new MediaPrintableArea((float) 8.25, (float) 10.0, (float) 8.5, (float) 11.0, MediaPrintableArea.INCH));

                MessageFormat empty = new MessageFormat("");
                MessageFormat footerFormat = new MessageFormat("- {0} -");

//                    printable.print(PrintMode.FIT_WIDTH, empty, footerFormat, true, aset, false);
                Paper paper = new Paper();
                paper.setImageableArea(0, 0, 700, 890);
                paper.setSize(700, 890);

                PageFormat format = new PageFormat();
                format.setPaper(paper);
                format.setOrientation(PageFormat.PORTRAIT);

//        printjob.setPrintable(printable, format);
                BufferedImage img = new BufferedImage(700, 890, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = img.createGraphics();
                g2d.setColor(Color.WHITE);
                g2d.fill(new Rectangle(0, 0, 890, 700));

                Printable printable = infoTable.getPrintable(JTable.PrintMode.FIT_WIDTH, null, null);
                try {
                    printable.print(g2d, format, 0);
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
                g2d.dispose();

                try {
                    ImageIO.write(img, "png", new File("Print.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                //this.dispose();
                break;

            default:
                break;
        }

    }
}