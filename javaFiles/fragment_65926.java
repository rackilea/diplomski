System.out.println("How many questions are on your test?");
  int num = scan.nextInt();
  Question[] test = new Question[num];  for(int i=0; i<num; i++)
  {
   System.out.println("Question " + (i+1) + ": Essay or multiple choice question? (e/m)");

    type = scan.next();