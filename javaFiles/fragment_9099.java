tv1 = (TextView)findViewById(R.id.tv1);
    tv1.setText("123+123");
    hzw = (HorizontalScrollView)findViewById(R.id.hzw);
    b = (Button)findViewById(R.id.b);

    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tv1.append("d+1+cff");

            hzw.post(new Runnable() {
                @Override
                public void run() {
                    hzw.fullScroll(View.FOCUS_RIGHT);
                }
            });
        }
    });