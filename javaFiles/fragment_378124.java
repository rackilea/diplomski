int autoIncKeyFromApi = -1;
rs = stmt.getGeneratedKeys();
if (rs.next()) {
    autoIncKeyFromApi = rs.getInt(1);
} else {
    // do what you have to do
}
System.out.println(autoIncKeyFromApi);