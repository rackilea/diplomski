Intent intent = getIntent();
if (intent.hasExtra("myExtra") && intent.hasExtra("myExtraInt")){                                
   TextView mText = (TextView)findViewById(R.id.textView1);
   mText.setText("user name "+intent.getStringExtra("myExtra")+"!");
   int extraInt = intent.getIntExtra(myExtraInt);
}