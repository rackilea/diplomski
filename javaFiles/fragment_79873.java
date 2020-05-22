protected void createAndAddDataLabel(Data data) {

    JLabel lblHomer = new JLabel(data.names);
    lblHomer.setIcon(new ImageIcon(data.fileID));

    cooX = cooX + 20;
    cooY = cooY - 20;

    panel_1.add(lblHomer, "cell " + cooX + " " + cooY);
    panel_1.revalidate();

    if (!"mother".equals(data.CBvalue)) {
        lblHomer.addMouseListener(new DataMouseHandler());
    }

}