private int calculate() {
    Vector<Integer> myvector = new Vector();

    TableModel mode = new DefaultTableModel();
    mode = jTable2.getModel();
    int n = mode.getRowCount();
    for (int i = 0; i < n; i++) {
        if (mode.getValueAt(i, 3) != null) {

            myvector.add((Integer) mode.getValueAt(i, 3));
        }
    }
    return myvector.size();
}

//then I validate with a button
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    int numofvalidrows;
    numofvalidrows = calculate();

    if (numofvalidrows == 0) //if the size of the vector is 0 then the jtable is empty
    {
        System.out.println("You need to add people to the jtable, because the table is empty");
    } else {
        // I get the values of the jtable with 
        for (int i = 0; i < n; i++) {
            if (model.getValueAt(i, 3) != null) {  //whith this "if" I print only data, not print null of the empty cells in jtable
                System.out.print(model.getValueAt(i, 3)) 

            }

        }
    }
}