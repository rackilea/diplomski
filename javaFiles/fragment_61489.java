// Example that assures that an UncaughtExceptionHandler
// is being invoked by flagging execution with file creation.

public class MainActivity extends ... implements ... {

    private File mCrashFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mCrashFile = new File(getFilesDir(), "crash");

        // Crash file existence means the application has crashed before.
        Log.d(TAG, "crash file exists: " + mCrashFile.exists());

        // Clear crash flag.
        if (mCrashFile.exists()) {
            Log.d(TAG, "crash file delete: " + mCrashFile.delete());
        }

        Thread.setDefaultUncaughtExceptionHandler(new DefExcHandler());

        ...

    }

    private class DefExcHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread thread, Throwable ex) {

            // Set crash flag.
            try {
                mCrashFile.createNewFile();
            } catch (IOException e) {
                // dunno if it really prints anything
                e.printStackTrace();
            }
        }
    }
}