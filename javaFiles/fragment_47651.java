private void colorchange() {
        final Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                MyActivityName.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                         rl = findViewById(R.id.am);
                        int[] androidColors = getResources().getIntArray(R.array.androidcolors);
                        int randomcolor = androidColors[new Random().nextInt(androidColors.length)];
                        rl.setBackgroundColor(randomcolor);
                    }
                });

            }

        },0,5000);
    }