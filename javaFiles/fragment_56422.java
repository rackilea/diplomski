File f = new File("Sale Receipts");
  f.mkdir();
  BufferedWriter bw = new BufferedWriter(new FileWriter("Sale Receipts/Sale" + Lrecno.getText() + ".TXT"));
  String receipt="";
  while (rs.next()) {
        receipt += rs.getString("PART_DESC") + "  " + rs.getString("QUNTY") + "  "
                   + rs.getString("UNIT_SALE") + "  " + rs.getString("TOTAL_SALE");
        String[] rece = receipt.split("\n");
        for (int i = 0; i < rece.length; i++) {
            bw.write(receipt);
            bw.flush();
            bw.newLine();
        }
        JOptionPane.showMessageDialog(this, "Item sold successfully",
                "Success", JOptionPane.PLAIN_MESSAGE);
    }