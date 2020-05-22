boolean previousTapDetected;
...
button.setOnClickListener(new View.OnClickListener){
 @Override
        public void onClick(View v) {
            .......
            if(previousTapDetected) {
                //We got a tap during the delay
            }
            Handler handler = new Handler();
            previousTapDetected = true;
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    previousTapDetected = false;
                //Do some thing after the delay

               }
            }, randomDelay);

            //Do other things
        }
    });