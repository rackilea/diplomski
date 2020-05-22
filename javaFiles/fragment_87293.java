StringBuilder builder = new StringBuilder();
while (rs.next()) {
   builder.append(rs.getString(“name”));
   builder.append(“ “);
   builder.append(rs.getString(“nachname”));
   builder.append(“\n“);       
}
ta.setText(builder.toString());