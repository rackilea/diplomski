button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                int j = 0;
                Log.d("tag", "sec " + i);
                while (i++ < 15) {
                    Log.d("tag", "sec " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final int finalJ = j;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "num" + (finalJ), Toast.LENGTH_SHORT).show();
                        }
                    });
                    j++;
                }
            }
        }).start();
    }
});