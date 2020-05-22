findViewById(R.id.spinner).setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Toast.makeText(MainActivity.this,"CallAPI",Toast.LENGTH_SHORT).show();
            return false;
        }
    });