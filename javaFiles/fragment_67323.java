public void generateQuestion(Button button1, Button button2, Button button3, Button button4) {

   Random rand = new Random();
   int a = rand.nextInt(21);
   int b = rand.nextInt(21);

   question.setText(Integer.toString(a) + "+" + Integer.toString(b));
   int locationOfCorrectAnswer = rand.nextInt(4);

   int incorrectAnswer;

   for (int i = 0; i < 4; i++) {

       if (i == locationOfCorrectAnswer) {
           answers.add(a + b);
       } else {
           incorrectAnswer = rand.nextInt(41);
           while (incorrectAnswer == a + b) {

               incorrectAnswer = rand.nextInt(41);

           }
           answers.add(incorrectAnswer);
       }
   }
   button1.setText(Integer.toString(answers.get(0)));
   button2.setText(Integer.toString(answers.get(1)));
   button3.setText(Integer.toString(answers.get(2)));
   button4.setText(Integer.toString(answers.get(3)));


}