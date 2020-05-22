while (rs.next()) {
   users.add(rs.getString("username"));
}

if (users.isEmpty()) {
   // not found!
}