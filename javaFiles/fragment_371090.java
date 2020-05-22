answer = new RadioButton[4];
radioGroup = new RadioGroup[4];
for (int i = 0; i < 4; i++) {
     radioGroup[i] = new RadioGroup(this);
     radioGroup[i].setOrientation(RadioGroup.VERTICAL);
     int j=0;
     for (Answer an : answers) {
         String answers_log = an.getAnswer();
         answer[j] = new RadioButton(this);
         answer[j].setText(answers_log);
         answer[j].setId(j);
         radioGroup[i].addView(answer[j]);
         j++;
     }
linearLayout.addView(radioGroup[i]);