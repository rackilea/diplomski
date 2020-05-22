Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    resetButtons();
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
            }, 5000);