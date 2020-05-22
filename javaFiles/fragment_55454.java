public class MyCountDownTimer extends CountDownTimer {
        private MyCallback myCallback;

        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        public Interface MyCallBack{
            void callback();
        }

        @Override
        public void onFinish() { 
            myCallback.callback();
        }

        @Override
        public void onTick(long millisUntilFinished) {
           Log.e("TESTINg","" + millisUntilFinished/1000);
        }

        public void setMyCallback(MyCallback myCallback){
            this.myCallback = myCallback;
        }
    }