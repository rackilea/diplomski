while (rs.next()) {
   ta.append(rs.getString(“name”));
   ta.append(“ “);
   ta.append(rs.getString(“nachname”));
   ta.append(“\n“);
}