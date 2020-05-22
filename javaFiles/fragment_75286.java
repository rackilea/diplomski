@Override
public void run() {
    while (true) {
        if (mLogOutStream != null && !mQueue.isEmpty()) {
            try {
                mLogOutStream.write(mQueue.poll().getDataStringLine().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (mLogFile.length() > AppConstants.LOG_FILE_MAX_SIZE) {
                synchronized (this) {
                    reportCurrentLogFileIsFinished(mLogFile);
                    try {
                        if (mLogOutStream != null) {
                            mLogOutStream.flush();
                            mLogOutStream.close();
                            mLogOutStream = null;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mLogFile = createLogFile();
                        mLogOutStream = new FileOutputStream(mLogFile, true);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}