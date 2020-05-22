private final Handler mUiThreadHandler = new Handler(Looper.getMainLooper());

void fromAnyThread() {
    final String importantDataFromBackGroundThread = "!!!";
    mUiThreadHandler.post(new Runnable() {
        @Override
        public void run() {
            System.out.println("Hi from Ui Thread:" + importantDataFromBackGroundThread);
        }
    });
}