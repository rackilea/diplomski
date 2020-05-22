handler.post(new Runnable() {
    @Override
    public void run() {
        final Runnable self = this;
        new Task() {
            @Override
            public void onTaskFinish() {
                handler.post(self);
            }
        }.execute()
    }
});