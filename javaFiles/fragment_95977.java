for (Iterator<String> it = myList.iterator(); it.hasNext(); ) {
   String str = it.next();
   System.out.print(str);
   if (it.hasNext()) {
      System.out.print(";");     
   }
}