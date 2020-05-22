HScore = (TextView) findViewById(R.id.hscore);
OnClickListener mHscoreListener = new OnClickListener()
{
    public void onClick(View v)
    {
     // DO INCREASE
     h1++;
     HScore.setText(h1 + "");
    };
};
HScore.setOnClickListener(mHscoreListener);