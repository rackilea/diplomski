System.out.println("Enter the student's third test score");
double score3 = Double.parseDouble(keyboard.nextLine());          
  while (score3 < 0 || score3 > 100)
  {
      System.out.println("Invalid score, plese reenter");
      System.out.println("Enter the student's third test score");
    score3 = Double.parseDouble(keyboard.nextLine());
  }