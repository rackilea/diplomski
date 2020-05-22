String str= "Hello World";
SpannableString spannable=  new SpannableString(str);
spannable.setSpan(new RelativeSizeSpan(1.5f), 0, 5, 0); //size
spannable.setSpan(new ForegroundColorSpan(Color.CYAN), 0, 5, 0);//Color
TextView txtview= (TextView) findViewById(R.id.textview);
txtview.setText(spannable);