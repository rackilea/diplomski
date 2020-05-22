final Runnable connect = new Runnable() {
    Handler progress = new Handler();

    @Override
    public void run() {

        String response = getJSON("http://api.wipmania.com/json"); 
        progress.post(new Runnable() {
            @Override
            public void run() {
                //do what you want with response
            }
        });
    }
};