while(inputStream.hasNext()){//reads from the file until there are no items left
  // ...
  ps.setString(1, reportidString);
  ps.setString(2, coursenameString);
  // ...
  ps.executeUpdate();
}
connection.commit();