List<String> collection = new ArrayList<String>();
String[] temp;
while ((line = br.readLine()) != null) {
   temp = line.split(",");
   if (temp.length > 0) {
      for (String s: temp) {
         collection.add(s);
      }
   }
}