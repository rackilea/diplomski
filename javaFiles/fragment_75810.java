private String selectStudent() {

    // initial value for result to return
    String result = "";

    // grab the index of the row selected on the table
    int initial = studenttable.getSelectionModel().getSelectedIndex();

    try {

        // SELECT query to execute
        String sqlSelect = "SELECT id FROM students";

        Connection conn = dbConnection.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(sqlSelect);

        // while there's a next row
        while(rs.next()) {

            // set temp to equal the id rs.next() is currently on
            String temp = rs.getString("id");
            // get the row id - 1 since we start at 0
            int temp1 = rs.getRow() - 1;

            // if temp1 is equal to the index we selected
            if(temp1 == initial) {

                // make it equal to result
                result = temp;
            }
        }

        // close the connection
        conn.close();

    } catch (SQLException ex) {

        ex.printStackTrace();
    }

    // return the row to delete
    return result;
}