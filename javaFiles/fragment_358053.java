public static void main(String[] args) {
        DataRetrieve dr = new DataRetrieve();
        //here i want to print that table rows into Console using this
        System.out.println(); // How do you print here that table rows?

        ResultSet rs = dr.getResultSet();
        while (rs.next()) {
            System.out.println(rs.getString(1)); //gets the first column's rows.
        }
}