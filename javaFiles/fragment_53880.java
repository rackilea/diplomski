PrintWriter writer = new PrintWriter("grep__output", "UTF-8");
String s = null;
while ((s = stdInput.readLine()) != null) {
   writer.println(s);
} 
writer.close();