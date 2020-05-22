button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final int[] i = {0};
        final int[] j = {0};
        final int delayTime = 1000;

        Log.d("tag", "sec "+ i[0]);
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(i[0]++<15) {
                    Log.d("tag", "sec " + i[0]);
                    Toast.makeText(getApplicationContext(), "num" + (j[0]), Toast.LENGTH_SHORT).show();
                    j[0]++;
                    handler.postDelayed(this, delayTime);
                }
            }
        };
        handler.postDelayed(runnable, delayTime);
    }
});