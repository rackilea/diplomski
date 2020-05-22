for (int i = 1; i <= logfile.getTotalLines(); i++) {
    t = new Thread(threadFile, "logFile_Thread_" + i);
    t.start();
}

static Runnable threadFile = new Runnable() {

    public void run() {
        // TODO Auto-generated method stub
        ++currentLine;
        timer.schedule(new timedTask(), (long)  
        logfile.getFileHash().get(currentLine).getTimeStampInMilli());
    }
};