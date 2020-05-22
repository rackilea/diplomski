Intent intent = getIntent();
    if (intent.getExtras() == null) {
        // Do first time stuff here
    } else {
        // Do stuff with intent data here
        Bundle b = getIntent().getExtras();
        title = b.getString("TITLE");
        time = b.getString("TIME");
        date = b.getString("DATE");