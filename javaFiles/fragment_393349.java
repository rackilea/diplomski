private static final Integer DELAY_TIME = 3000;
private Handler mHanlder = new Handler();

mHanlder.postDelayed(mAnimRunnable, DELAY_TIME)// Same Delay using one Constant variable.
mHanlder.postDelayed(mTextUpdateRunnable, DELAY_TIME)// Same Delay using one Constant variable.

private Runnable mAnimRunnable = new Runnable() {
        public void run() {
         //Your Animation Task  
        }
    };

    private Runnable mTextUpdateRunnable = new Runnable() {
        public void run() {
         //Your Text update Task  
        }
    };