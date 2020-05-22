DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

    for (int i=0;i<model.getRowCount();i++) {
          Boolean checked=(Boolean)model.getValueAt(i,7);
          if (checked!=null && checked) {
               model.removeRow(i);
               i--;
          }
    }