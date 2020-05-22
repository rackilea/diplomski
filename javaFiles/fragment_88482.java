@Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        BackgroundWorker fetchRiddles = new BackgroundWorker(DashActivity.this,"retrieveRiddles");
        switch (arg0.getId()) {
        case 100:  // in this case i usually put "R.id.Button1:" but my problem is that my buttons are dynamic
            fetchRiddles.execute("0,"+username);
            break;
        case 200:
            fetchRiddles.execute("1,"+username);
            break;
    }