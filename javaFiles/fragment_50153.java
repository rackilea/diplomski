String receive;

if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                receive= null;
            } else {
                receive= extras.getString("TEXTID");
            }
        } else {
            receive= (String) savedInstanceState.getSerializable("TEXTID");
        }