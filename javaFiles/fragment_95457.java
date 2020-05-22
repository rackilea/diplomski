public void initializeVar(){
    findUpperCase = (Button) findViewById(R.id.finduppercase);
            everyOther = (Button) findViewById(R.id.everyother);
            vowelReplace = (Button) findViewById(R.id.vreplace);
            vowelCount = (Button) findViewById(R.id.vcount);
            findUpperCase.setOnClickListener(this);
            everyOther.setOnClickListener(this);
            vowelReplace.setOnClickListener(this);
            vowelCount.setOnClickListener(this);
    }