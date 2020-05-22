/**
     * Program thread: Run
     * Description: Cycles every second (998 Milliseconds) to detect a change in time for song. Values on GUI are updated accordinly. 
     */    
    new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    if(isPlaying) {
                        currentTime = player.getCurrentTime();
                        totalTime = player.getMedia().getDuration();

                        updateTimeValues();
                        updateTimeSlider();

                        if(totalTimeText.equals(currentTimeText))
                        {
                            if(isLooping) {
                                handlecentreButtonClick();
                            }
                            else {
                                handleforwardButtonClick();
                            }
                        }

                        try {Thread.sleep(498); }catch (Exception e){}
                    }
                    try {Thread.sleep(500);if(isDragging) {isDragging=false;}}catch (Exception e){}
                }
            }
        }).start();