BufferedReader r = new BufferedReader(new FileReader(filename));
while (true) {
   String line = r.readLine();
   if (line==null) break;
   String cols[] line.split("\\s+");
   itemAmount += Integer.parseInt(cols[2]);
}
r.close();