public void showYears() {

    try {

        con = yearDao.connectToDB();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM YEARS;");

        view.setTableModel(new YearTableModel(rs));
        con.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}