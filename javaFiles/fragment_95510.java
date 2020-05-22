try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:")) {
    try (Statement st = conn.createStatement()) {
        st.execute("restore from C:\\__tmp\\thing.sqlite");

        // let's see if we can read one of the tables
        ResultSet rs = st.executeQuery("SELECT * FROM Table1");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

} catch (Throwable e) {
    e.printStackTrace(System.err);
}