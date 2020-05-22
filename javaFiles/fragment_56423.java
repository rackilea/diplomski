StringBuilder  receipt = new StringBuilder();
  while (rs.next()) {
        receipt.append( rs.getString("PART_DESC") + "  " + rs.getString("QUNTY") + "  "
                   + rs.getString("UNIT_SALE") + "  " + rs.getString("TOTAL_SALE"));
        receipt.append("\n");
        JOptionPane.showMessageDialog(this, "Item sold successfully",
                "Success", JOptionPane.PLAIN_MESSAGE);
  }
  bw.write(receipt.toString());
  bw.flush();
  bw.newLine();