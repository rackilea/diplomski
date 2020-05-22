private ViewFlipper mFliptest;
private Handler mHandler = new Handler();
private Random mRand = new Random();
private Runnable mFlip = new Runnable() {

    @Override
    public void run() {
        mFliptest.setDisplayedChild(mRand.nextInt());
        mHandler.postDelayed(this, mRand.nextInt(6) * 2000);
    }    
}

//in the onCreate method
mFliptest = (ViewFlipper) findViewById(R.id.menuFlipper);
mHandler.postDelayed(mFlip, randomTime);