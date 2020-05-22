@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

        //Other stuff
        //...
            //Remove this line ==> imageView.setBackgroundResource(R.drawable.launch_screen_image);
            relativeLayout.addView(imageView, relLayoutParam);

            setContentView(relativeLayout, relLayoutParam);

            //set image resource after setContentView
            imageView.setImageResource(R.drawable.launch_screen_image);

            //Use handler instead of Thread.sleep()
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //it calls continue() after 3 seconds of delay
                    continue();
                }
            },3000);


}