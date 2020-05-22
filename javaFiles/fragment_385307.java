mBtnPlayCourse = (Button) findViewById(R.id.btn_screenstart_playcourse);
    mBtnNewCourse = (Button) findViewById(R.id.btn_screenstart_newcourse);

    mBtnPlayCourse.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            final Intent i = new Intent(Screen_Start.this, Screen_Players.class);               
            startActivity(i);
        }
    });

    mBtnNewCourse.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            final Intent i = new Intent(Screen_Start.this, Screen_CreateCourse.class);
            startActivity(i);
        }
    });