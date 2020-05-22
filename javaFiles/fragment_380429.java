try {
  PrintWriter pw = new PrintWriter(BufferedWriter(new FileWriter("data.csv")));
}
catch(Exception e) {
  e.printStackTrace();
}