public void onRadioButtonClicked(View v){
        Log.i("Answer", "Answer is "+ ((RadioButton)v).getText());
        Intent intent = new Intent(Quiz.this, Question2.class);
        //send the answer to the next Activity if yo need
        intent.putExtra("answer", ((RadioButton)v).getText());
        //start next Activity
        startActivity(intent);
    }