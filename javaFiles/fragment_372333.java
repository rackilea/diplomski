FloatingActionButton fab = findViewById(R.id.fab);
fab.post(new Runnable() {
    @Override
    public void run() {
        // this callback will be executed after view is laid out
        for (int i = 0; i < pv.length; ++i) {
            pv[i] = new Point(getPointOfView(fab).x ,getPointOfView(fab).y);
        }
    }
})