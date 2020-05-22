new Thread(new Runnable() {
        @Override
        public void run() {
            mAccountsEnabled = PicasaDataSource.getAccountStatus(YourActivity.this);
        }
    }).start();