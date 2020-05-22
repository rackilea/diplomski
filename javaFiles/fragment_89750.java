try {
  FileWriter out = new FileWriter(dataFile);
  for (User u: userList) {
     out.append(u.toString() + "\n");
  }
  out.close(); // <- new!

} catch (IOException e) {
   e.printStackTrace();
}