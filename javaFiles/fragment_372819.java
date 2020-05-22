Future<String> result = executor.submit(new Callable<String>(){
    @Override
    public String call() {
        try {
            //..checking sms..//
            if (smsreceived) {return receivedMessage;}
            return null;
        } finally {
            mHandler.postDelayed(readSms, mInterval);
        }
    }
});