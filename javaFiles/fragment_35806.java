Object data[][] = { { "111Hello Ln", "Capital", "TX 77777" },
    { "222 Hello Ln", "Capital", "TX 77777" },
    { "333 Hello Ln", "Capital", "TX 77777" },
    { "444 Hello Ln", "Capital", "TX 77777" } };
String col[] = { "Name", "Capital", "TX" };

final DefaultTableModel model = new DefaultTableModel(data, col);
final JTable table = new JTable(model);

 ....

btn1.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        btn1MouseClicked(evt);

        Object [][] sl = {{"555 Hello Ln", "Capital", "TX 77777"}};
        model.addRow(ShippingLabel(sl[0]));

    }
});