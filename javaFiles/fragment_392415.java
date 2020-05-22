LinearLayout layout = (LinearLayout) findViewById(R.id.your_layout);

layout.setOnTouchListener(new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    });
});