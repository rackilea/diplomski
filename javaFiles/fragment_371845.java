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