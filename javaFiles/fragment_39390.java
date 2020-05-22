while ((newLine=f.readLine()) != null){
   StringTokenizer st = new StringTokenizer(newLine);
   while (st.hasMoreTokens()) {
      int number = Integer.parseInt(st.nextToken()); 
      input.add(number);
   }
}