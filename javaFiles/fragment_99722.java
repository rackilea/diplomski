CountDownTimer count = new CountDownTimer(20000, 1000)
            {

                int counter = 20;

                @Override
                public void onTick(long millisUntilFinished)
                {
                    // TODO Auto-generated method stub
                    counter--;
                    textView.setText(String.valueOf(counter));

                }

                @Override
                public void onFinish()
                {

            startActivity(i);
            overridePendingTransition(R.anim.pushin, R.anim.pushout);
                }
            };

            count.start();