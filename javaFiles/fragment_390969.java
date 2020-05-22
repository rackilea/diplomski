String answerStr = mathAnswers[i].getText();

    if(answerStr.isEmpty()){

          correctYesNo[i] = new JLabel("Not a valid answer/answer field empty!");
    } else {

         answer = Integer.parseInt(answerStr);
         correctAnswer = X * Y;
         //Rest of your code goes here
    }