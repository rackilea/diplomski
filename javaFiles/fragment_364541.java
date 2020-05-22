System.out.print("HEADER");
StringBuilder sep = new StringBuilder();
for(String rec: headings) {
   sep.append("*");
   if(rec != null && !rec.isEmpty()) {
      System.out.print(sep + rec);
      sep.setLength(0);
   }
}
System.out.println();