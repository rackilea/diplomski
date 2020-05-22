btnChoose.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();

        if (row == (-1) || col == (-1)) {
           JOptionPane.showMessageDialog(null, "Please Select a Date",
                 "Error", JOptionPane.WARNING_MESSAGE);
        } else {
           returnDate(row, col);
           GUI DS1 = new GUI(getFinalDate(), SoE);  // *****************
           dispose();
        }
     }
  });