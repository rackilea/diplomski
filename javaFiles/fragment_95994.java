public void onClick(View v) {

        // you need to keep a reference to the task so you can cancel it later
        if (mSensorTask != null) {
            // task already exists -- if running, stop it
            mSensorTask.cancel(false);
            mSensorTask = null;
        } else {
            // task doesn't exist -- make a new task and start it
            mSensorTask = new SensorTask();
            mSensorTask.execute();    
            // this will make doInBackground() run on background thread
        }

    };