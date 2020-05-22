protected int _getInitWorkerTime()
{   
        int vRun = 0;
        STime stNow = new STime(PWMSystem.newDate());
        int currFreq = _findAlertFrequency() / Constants.SECONDS_PER_MINUTE;
        int sElapsed = Constants.MINUTES_PER_DAY- stNow.elapsedMinutes(STime.midnight);
        int runsCompleted = sElapsed / currFreq;
        int remainLeft = (runsCompleted + 1) * currFreq;


                if (remainLeft > sElapsed)
                    vRun = remainLeft - sElapsed;
                else
                    vRun = sElapsed - remainLeft;


return (vRun * 60 + _BOOT_DELAY_SECONDS_START);