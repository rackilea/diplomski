private void helperFunction(final int index){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                View counter = (View) myListView.getChildAt(index);
                counter.setVisibility(View.VISIBLE);
            }
        }, (index * 1000) + 1000);
    }