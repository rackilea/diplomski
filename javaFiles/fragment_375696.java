private class ProcessThread extends Thread{
    private static final long TIME_THRESHOLD = 100; //100 MS but can change as desired
    private long lastSentTime = 0;
    private float value = 0f;
    private ReadingsUpdateData updater = new ReadingsUpdateData(values);
    public void run() {
        while(true) {
            if (System.currentTimeMillis() - lastSentTime < TIME_THRESHOLD) {
                try {
                    Thread.sleep(TIME_THRESHOLD - (System.currentTimeMillis() - lastSentTime));
                } catch (InterruptedException e) {}
            }

            value = getRandom();
            updater.setData(value);
            EventBus.getDefault().post(updater);
            lastSentTime = System.currentTimeMillis();
        }
    }
}