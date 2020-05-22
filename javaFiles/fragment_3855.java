pst.setLong(1, rowctr);
pst.setString(2, (String)this.jTable3.getModel().getValueAt(rowctr, 0));
pst.setInt(3, (int)this.jTable3.getModel().getValueAt(rowctr, 1));
pst.setInt(4, (int)this.jTable3.getModel().getValueAt(rowctr, 2));
pst.setDouble(5, (double)this.jTable3.getModel().getValueAt(rowctr, 3));
pst.setDouble(6, (double)this.jTable3.getModel().getValueAt(rowctr, 4));