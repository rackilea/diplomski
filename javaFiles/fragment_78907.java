TextView Display = (TextView) findViewById(R.id.tvresult); 
Random mRandom = new Random();      
Display.setText("WHAT????");
Display.setTextSize(mRandom.nextInt(75));
Display.setTextColor(Color.rgb(mRandom.nextInt(265),
mRandom.nextInt(265), mRandom.nextInt(265)));