while (rs.next()) {
      String name = rs.getString("name");
      System.out.println(name);
      // display more fields, etc.
      ...
}