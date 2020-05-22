while(myScan.hasNext()){
   String line = myScan.nextLine();
   if (myPat.matcher(line).find()) {
      System.out.println(line);
   }
}