new CountDownTimer(30000, 1000) {

         public void onTick(long millisUntilFinished) {
            if (String.valueOf(millisUntilFinished / 1000).equalsIgnoreCase("10")) {
                Toast.makeText(getApplicationContext(), "10 second remaining.!", Toast.LENGTH_SHORT).show();
                base.setVisibility(View.VISIBLE);
            }
        }

        public void onFinish() {

        }
    }.start();