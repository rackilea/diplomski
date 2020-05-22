PrintWriter out = res.getWriter();
File file = new File("C:\\Debug\\log20.txt");
if (file.exists()) {
  BufferedReader input = new BufferedReader(new FileReader(file));
  String line = "";
  while ((line = input.readLine()) != null) {
     out.println(line);
  }
}