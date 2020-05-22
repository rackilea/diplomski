Handler handler = new Handler();
    int delay=1000;
    Runnable rann=new Runnable() {
        @Override
        public void run() {
            //Write Your logic here which you want to perform periodically
            System.out.println("Handler is running : ");
            //to call the same thread repeatedly calling handler again
            handler.postDelayed(rann, delay);
        }
    };


    private void startHandler() {
        //here the handler will executes the rannable after that particulary delay milli seconds
        handler.postDelayed(rann, delay);
    }

    private void stopHandler() {
        handler.removeCallbacks(rann);
    }