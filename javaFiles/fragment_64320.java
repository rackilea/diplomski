public void load() {

  System.out.println("");
  System.out.println("Subject: "+subjectString);
  System.out.print("Homework Mark: \t");

  for(int i = 0; i <= arrayList1.size()-1; i++){
      System.out.print(arrayList1.get(i) + "\t");
   }

   System.out.println("");
   System.out.print("Exam Mark: \t");
   for(int i = 0; i <= arrayList2.size()-1; i++){
      System.out.print(arrayList2.get(i) + "\t");
   }
   System.out.println("");
}