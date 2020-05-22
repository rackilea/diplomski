for (Answer an : answers) {
  if (qn.getID() == an.getQuestion_id_answer()) {
       answer[j] = new RadioButton(this);
         ...your code here...      
        answer[j].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // your code here...
             }
        });
         j++;
     }
}