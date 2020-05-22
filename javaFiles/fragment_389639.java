try {
    connectDB();
    Statement st =  con.createStatement();
    rs = st.executeQuery("SELECT MAX(DaySheet_no) FROM tbl_day_sheet_daily_income");
    if (rs.next()) {
        int billNumber = rs.getInt(1) + 1;
        txt_no.setText(Integer.toString(billNumber));
    }
    con.close();
} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, ex.toString());
}