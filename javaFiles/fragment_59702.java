try {

value8 = Double.parseDouble(t8.getText());

} catch (NumberFormatException) {

value8 = 0.0;

}

String query = "INSERT INTO your_table(val) VALUES (?)";
PreparedStatement st = con.prepareStatement(query);
if ( value8 != null && !value8.isEmpty()) {
   st.setDouble(1, value8);
} else {
   st.setNull(1, Types.DOUBLE);
}