JTable table = new JTable();
DefaultTableModel model = new DefaultTableModel();
// This is pointless as the model isn't actually attached to anything
model.fireTableDataChanged();
// This is pointless as the table hasn't been added to anything
table.repaint();
JScrollPane scrollPane = new JScrollPane(table);
try {
    orclConn.statement = orclConn.getConnection().createStatement();
    orclConn.resultset = orclConn.statement.executeQuery(
    "SELECT JOR,DANA,NRXYJOR FROM froshtnykalayhatw WHERE dt = '"+d+"'  ");

    while (orclConn.resultset.next()) {
        //jlFroshraw is array list
        // This looks dangrous to me, as I can't see where it's been created
        // or if it's been cleared.
        // This could mean that all previous queries are still contained
        // with in it...
        jlFroshraw.add(new IydaShow(orclConn.resultset.getString(1), orclConn.resultset.getInt("dana"), orclConn.resultset.getInt("nrxyjor")));
    }
} catch (Exception df) {
    df.printStackTrace();
}

// This is actually okay
table.setModel(model);
model.setColumnIdentifiers(new String[]{"dd", "nn", "mm"});

// Read the previous statement about jlFroshraw list
for (IydaShow p : jlFroshraw) {
    model.addRow(new Object[]{p.jor, p.chandJor, p.nrxyfroshraw});
}

pnl.add(scrollPane, BorderLayout.CENTER);