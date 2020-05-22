if ( savedInstanceState == null ) // the app just started running
      {
         winCount = 0; 
         loseCount = 0; 
         resultsTextView.setTextColor(Color.BLACK);
      } 
      else 
      {

         winCount = savedInstanceState.getInt("MY_POINTS");
         loseCount = savedInstanceState.getInt("HOUSE_POINTS");

         lastDie1 = savedInstanceState.getInt("DIE1_STATE");
         lastDie2 = savedInstanceState.getInt("DIE2_STATE");


         die1ImageView.setImageResource(lastDie1);
         die2ImageView.setImageResource(lastDie2);

         resultsTextView.setText(savedInstanceState.getString("RESULTS"));
         pointsTextView.setText(savedInstanceState.getString("POINTS"));
         rollTextView.setText(savedInstanceState.getString("ROLL"));


      }