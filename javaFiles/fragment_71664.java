final Button button5 = (Button) findViewById(R.id.button5);
//  use button5 instead of button below one
button5.setOnClickListener(new View.OnClickListener() {   
        public void onClick(View v){
            Intent myIntent = new Intent(start.this, QuestionActivity.class);
            start.this.startActivity(myIntent);
        }
    });