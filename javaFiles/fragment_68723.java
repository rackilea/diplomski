parent.runOnUiThread(new Runnable() {

        @Override
        public void run() {
            new GetUserHttpTask().execute();
        }
});