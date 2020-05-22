for(String s: histogram.keySet()) {
   StringBuilder str = new StringBuilder();
   Integer value = histogram.get(s);
   if (value!=null)
      for(int x = 0; x < value.intValue(); x++) {
         str.append("*");
      }
   output+=s+"\t"+str.toString()+"\n";
}