System.out.print("Enter exam scores      :");

for(int y = 1; y <= numberofexams; y++) {
  examgrades = NumScanner.nextDouble();

  if(examgrades < 0) {
    y = 1;
    continue;
  }  

  System.out.println();

  if(y > numberofexams)  break;

  sum += examgrades;  //exam average
  sum2 += examgrades; //class average


} // number of exams