import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FlooringOrders extends JFrame implements ActionListener {

    private JLabel lblFloorType, lblRoomSize, lblLength, lblWidth, lblName,
            lblAddress, lblOrderInfo, lblTotal;
    private JRadioButton rbtnWood, rbtnCarpet;
    private JButton btnCalculate, btnSubmit, btnOrders;
    private ButtonGroup grpType;
    private JTabbedPane tab;
    private JTextField txtLength, txtWidth, txtArea, txtName, txtAddress;
    private JTextArea txtOrderInfo, txtTotal, txtCustomer;
    private JPanel p1, p2, p3, p4;
    private double Length, Width, Area, Total;
    private String sLength, sWidth, sArea, sTotal, fType, insertQuery;
    private PreparedStatement myQuery;
    private ResultSet rs;
    private DecimalFormat df;

    public FlooringOrders() {

        super("Flooring Orders");

        df = new DecimalFormat("#,###,###.00");

        tab = new JTabbedPane();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        lblFloorType = new JLabel("Choose Floor Type: ");
        lblRoomSize = new JLabel("Enter Room Size: ");
        lblLength = new JLabel("Length (ft): ");
        lblWidth = new JLabel("Width (ft): ");
        lblName = new JLabel("Enter Name: ");
        lblAddress = new JLabel("Enter Address: ");
        lblOrderInfo = new JLabel("Order Info: ");
        lblTotal = new JLabel("Total: ");

        rbtnWood = new JRadioButton("Wood - $20/sq. ft.");
        rbtnCarpet = new JRadioButton("Carpet - $10/sq. ft.");
        grpType = new ButtonGroup();

        btnCalculate = new JButton("Calculate Area");
        btnSubmit = new JButton("Submit");
        btnOrders = new JButton("Customer Orders");

        txtLength = new JTextField(10);
        txtWidth = new JTextField(10);
        txtArea = new JTextField(10);
        txtName = new JTextField(10);
        txtAddress = new JTextField(10);

        txtOrderInfo = new JTextArea(15, 15);
        txtTotal = new JTextArea(15, 15);
        txtCustomer = new JTextArea(15, 15);

        grpType.add(rbtnCarpet);
        grpType.add(rbtnWood);

        getContentPane().add(tab);

        p1.add(lblFloorType);
        p1.add(rbtnWood);
        p1.add(rbtnCarpet);
        p1.add(lblRoomSize);
        p1.add(lblLength);
        p1.add(txtLength);
        p1.add(lblWidth);
        p1.add(txtWidth);
        p1.add(btnCalculate);
        p1.add(txtArea);
        tab.add("Flooring", p1);

        p2.add(lblName);
        p2.add(txtName);
        p2.add(lblAddress);
        p2.add(txtAddress);
        p2.add(btnSubmit);
        tab.add("Customer Info", p2);

        p3.add(lblOrderInfo);
        p3.add(txtOrderInfo);
        p3.add(lblTotal);
        p3.add(txtTotal);
        tab.add("Total", p3);

        p4.add(btnOrders);
        p4.add(txtCustomer);
        tab.add("Order List", p4);

        btnCalculate.addActionListener(this);
        btnSubmit.addActionListener(this);
        btnOrders.addActionListener(this);

    } // end constructor

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("");
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource().equals(btnCalculate)) {
            sLength = txtLength.getText();
            sWidth = txtWidth.getText();
            fType = "";
            Length = sLength.isEmpty() ? 0.0 : Double.parseDouble(sLength);
            Width = sWidth.isEmpty() ? 0.0 : Double.parseDouble(sWidth);
            Area = 0;
            Total = 0;
            Area = Length * Width;
            if (rbtnWood.isSelected()) {

                Total = Area * 20;
                fType.equals("Wood");

            } else if (rbtnCarpet.isSelected()) {

                Total = Area * 10;
                fType.equals("Carpet");

            } // end if/else

            sArea = String.valueOf(df.format(Area));
            sTotal = String.valueOf(df.format(Total));
            txtArea.setText(sArea);
            txtTotal.setText(sTotal);

            System.out.println("Calculate Area pressed");

        } // end if

        if (a.getSource().equals(btnSubmit)) {

            newOrder();

            System.out.println("Submit pressed");

        } // end if

        if (a.getSource().equals(btnOrders)) {

            orderList();

            System.out.println("Customer Orders pressed");

        } // end if

    } // end actionPerformed

    public void newOrder() {
        insertQuery = "INSERT into CustomerOrders(CustomerName, CustomerAddress,FloorType, RoomSize, Total) values(?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            Connection conn = DriverManager.getConnection("");
            ps = conn.prepareStatement(insertQuery);
            ps.setString(1, txtName.getText());
            ps.setString(2, txtAddress.getText());
            ps.setString(3, fType);
            ps.setDouble(4, Area);
            ps.setDouble(5, Total);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Thank you for your order!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    } // end newOrder

    public void orderList() {
        Statement stmt = null;
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * from CustomerOrders");
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i < columns; i++) {
                    txtCustomer.setText(rs.getString(i) + " ");
                    System.out.print(rs.getString(i) + " ");
                    System.out.println();

                } // end for

            }// end while
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    } // end orderList

} // end class