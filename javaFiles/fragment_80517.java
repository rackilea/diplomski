public void run() {

    for (int i = 0; i < 5; i++) {
        b=b+""+a.charAt(i);

        //one of the ways to update UI controls from non-UI thread.
        runOnUiThread(new Runnable()
        {               
            @Override
            public void run()
            {
                mTextView.setText(b); //no problems here :)                 
            }
        });

        Log.d("Letters",""+b);
            try {
                  sleep(2000); 
           } catch (InterruptedException e) {}
    }
}