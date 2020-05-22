vs.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

    public void onCompletion(MediaPlayer mp) {

             splash.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Intent main = new Intent(splash.this, tabhost.class);
                        splash.this.startActivity(main);
                        splash.this.finish();
                    }
                });
    }