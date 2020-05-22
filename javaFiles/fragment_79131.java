@Override
        protected Void doInBackground(Void... arg0) {
            this.runOnUiThread(new Runnable() {
            public void run() {
                addTextView(R.id.tvResult, 1234, "s");
        });
            return null;
        }