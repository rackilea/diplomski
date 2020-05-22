opt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (option1.equals(answer)) {
                opt1.setBackgroundColor(Color.GREEN);
                mScore++;
            } else
                opt1.setBackgroundColor(Color.RED);
            sco.setText("Score : " + mScore);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mQuestionNumber++;
                    qn.setText("Question : " + mQuestionNumber);
                    updateQuestion();
                    opt1.setBackgroundColor(Color.CYAN);
                }
            }, 1500);
        }
    });