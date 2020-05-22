public boolean onTouch(View v, MotionEvent event) {
        if (ADS_VIDEO.contains(v.getId()) && event.getAction() == MotionEvent.ACTION_DOWN) {
            intentVideo = new Intent(getBaseContext(),AdVideoActivity.class);
            startActivity(intentVideo);
        }

        return false;
    }