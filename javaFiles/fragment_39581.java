Bundle bundle= getIntent().getExtras();
    if (bundle != null) {
       editText.setText (bundle.getString ("string"));
    }
    else {
       editText.setText ("Some string");
    }