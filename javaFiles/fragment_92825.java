public void value (){

    Scanner answerScanner = new Scanner(getResources().openRawResource(R.raw.answer));
     Scanner questionScanner = new Scanner(getResources().openRawResource(R.raw.question));

    ArrayList<String> answerList = new ArrayList<String>();
      ArrayList<String> questionList = new ArrayList<String>();

       try {
           while (answerScanner.hasNextLine() ) {
               answerList.add(answerScanner.nextLine());  
               questionList.add(questionScanner.nextLine()); 
           }
       } finally {
           s.close();    
       }  

       int nextInt = random.nextInt(questionList.size());

       String answerString = answerList.get(nextInt);
       String questionString = questionList.get(nextInt);

       yourAnswerString = answerString.substring(2);
       yourQuestionString = questionString.substring(2);

   }