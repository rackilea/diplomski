//This is the command to add a count
    tap.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            counter++;
            display.setText(" " + counter);
            if (counter > 10){
             words.setText("C");
            }
            else if (counter > 7){
             words.setText("B");
            }
            else{
             words.setText("A");
            }
          }
      });

    reset.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            counter = 0;
            display.setText(" " + counter);
            words.setText("A");
         }
      });