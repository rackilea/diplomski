public static int idColumn = 0;

for (Customers i : customersList) {
    if (i.getId() == jTable1.getValueAt(jTable1.getSelectedRow(), idColumn)) {
        Customers selectedCustomer = i;
    }
}