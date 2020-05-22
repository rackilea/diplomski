int[] textViews = {R.id.textView1, R.id.textView2, R.id.textView3};
    String[] messages = {"one", "two", "three"};

     for (int i = 0; i < 3; i++) {
            TextView tv = (TextView) findViewById(textViews[i]);
            tv.setText(messages[i]);
        }