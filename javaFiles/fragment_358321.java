String line = Input.nextLine();
Scanner lineScanner = new Scanner(line);//Scanner can also work on a String instead of a InputStream
while(lineScanner .hasNext()){
    if(lineScanner .hasNextFloat()){
      Grade=lineScanner .nextFloat();
      P.setGrades(Grade);
      j=0;k=1;
      continue;}
    if(k==1){
      P.getGPA();
      P=new Person();
      k=0;}
    if(j==1){
      P.setLastName(lineScanner .next());
      continue;}
    P.setFirstName(lineScanner .next());
    i++;
    j=1;
}