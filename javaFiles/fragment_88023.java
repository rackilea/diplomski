setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mp = MediaPlayer.create(TestSonido.this, R.raw.whippingsound);  
                    mp.start();
                }
            })