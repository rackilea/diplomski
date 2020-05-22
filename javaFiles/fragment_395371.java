while (s.hasNext()) {
   if (s.hasNextInt()) {
       int myInt = s.nextInt();
       System.out.println(myInt);
   } else {
       String dateAsString = s.next();
       System.out.println(dateAsString);
   }
}