btn_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    mediaPlayer.setDataSource(String.valueOf(url[0]));
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException | IllegalArgumentException e) {
                    e.printStackTrace();
                }

            }
        });