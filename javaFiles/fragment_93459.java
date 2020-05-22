List<String[]> collection = new ArrayList<String[]>();
String[] temp;
while ((line = br.readLine()) != null) {
   temp = line.split(",");
   if (temp.length > 0) {
      collection.add(temp);
   }
}