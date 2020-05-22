myHandler = new Handler();
count = 0;
public void rotateImage(final View myView, final int size) {


    runnable = new Runnable() {

        @Override
        public void run() {

            count++;
            myView.setRotation(myView.getRotation() + size);
            if(count == 10){
               myHandler.removeCallBack(runnable );
            }
           myHandler.postDelayed(this, 1000); // 1000 means 1 second duration
         }
        };
        myHandler.postDelayed(runnable, 180); // 180 is the delay after new runnable is going to called

}