public void requestPoint(View v) {
    textProgress.setText("Requesting A Point");
    handler.postDelayed(new Runnable(){
        public void run(){ 
            progressBar.setProgress(5);
            textProgress.setText("Request Received!");
        }
    }, 200);

    handler.postDelayed(new Runnable(){
        public void run(){ 
            ....
        }
    }, 700);
....
}