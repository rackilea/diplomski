Thread thread = new Thread()
{
    @Override
    public void run() {
    runOnUiThread(new Runnable() //run on ui thread
    {
        public void run() 
        { 
            profilePic.setImageBitmap(image_profile);

        }
    });
    }
    };
   thread.start();