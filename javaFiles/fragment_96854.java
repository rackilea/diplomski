long lastTimeofCall = 0L;
long lastTimeofUpdate = 0L;
long threshold_time = 10000;

    /* (non-Javadoc)
     * @see android.database.ContentObserver#onChange(boolean)
     */
    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);

        Log.d("content service", "on change called");

        lastTimeofCall = System.currentTimeMillis();

        if(lastTimeofCall - lastTimeofUpdate > threshold_time){

         //write your code to find updated contacts here

          lastTimeofUpdate = System.currentTimeMillis();
        }

    }