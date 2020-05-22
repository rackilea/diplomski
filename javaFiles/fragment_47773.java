// avoid GC in your threads. declare nonprimitive variables out of onDraw
    float smoothedDeltaRealTime_ms=17.5f; // initial value, Optionally you can save the new computed value (will change with each hardware) in Preferences to optimize the first drawing frames 
    float movAverageDeltaTime_ms=smoothedDeltaRealTime_ms; // mov Average start with default value
    long lastRealTimeMeasurement_ms; // temporal storage for last time measurement

    // smooth constant elements to play with
    static final float movAveragePeriod=40; // #frames involved in average calc (suggested values 5-100)
    static final float smoothFactor=0.1f; // adjusting ratio (suggested values 0.01-0.5)

    // sample with opengl. Works with canvas drawing: public void OnDraw(Canvas c)   
    public void onDrawFrame(GL10 gl){       
        updateGame(gl, smoothedDeltaRealTime_ms); // divide 1000 if your UpdateGame routine is waiting seconds instead mili-seconds.
        drawGame(gl);  

        // Moving average calc
        long currTimePick_ms=SystemClock.uptimeMillis();
        float realTimeElapsed_ms;
        if (lastRealTimeMeasurement_ms>0){
        realTimeElapsed_ms=(currTimePick_ms - lastRealTimeMeasurement_ms);
        } else {
                 realTimeElapsed_ms=smoothedDeltaRealTime_ms; // just the first time
        }
        movAverageDeltaTime_ms=(realTimeElapsed_ms + movAverageDeltaTime_ms*(movAveragePeriod-1))/movAveragePeriod;

         // Calc a better aproximation for smooth stepTime
        smoothedDeltaRealTime_ms=smoothedDeltaRealTime_ms +(movAverageDeltaTime_ms - smoothedDeltaRealTime_ms)* smoothFactor;

        lastRealTimeMeasurement_ms=currTimePick_ms;
    }

    // Optional: check if the smoothedDeltaRealTIme_ms is too different from original and save it in Permanent preferences for further use.