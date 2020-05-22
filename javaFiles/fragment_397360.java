...
    Handler handler = new Handler();
    final View finalView = view;
    handler.postDelayed(new Runnable() {

        @Override
        public void run() {
            finalView.setBackgroundResource(R.drawable.button_bg_rounded_corners);
            updateQuestion();
            ...