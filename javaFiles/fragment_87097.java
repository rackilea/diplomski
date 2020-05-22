TextView activity1 = (TextView) findViewById(R.id.activity1);
TextView activity2 = (TextView) findViewById(R.id.activity2);
TextView activity3 = (TextView) findViewById(R.id.activity3);
TextView activity4 = (TextView) findViewById(R.id.activity4);

activity1.setOnClickListener(new GenericClickListener(thia, Activity1.class));
activity2.setOnClickListener(new GenericClickListener(this, Activity2.class));
activity3.setOnClickListener(new GenericClickListener(this, Activity3.class));
activity4.setOnClickListener(new GenericClickListener(this, Activity4.class));