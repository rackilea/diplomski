new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                // just put here your wav file
                File yourWavFile = new File(Environment.getExternalStorageDirectory() + "/" + AUDIO_FOLDER, fileName);
                FileInputStream fis = new FileInputStream(yourWavFile);
                int minBufferSize = AudioTrack.getMinBufferSize(16_000,
                AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
                AudioTrack at = new AudioTrack(AudioManager.STREAM_MUSIC, 16_000,
                AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT,
                    minBufferSize, AudioTrack.MODE_STREAM);

                int i = 0;
                byte[] music = null;
                try {
                        music = new byte[512];
                        at.play();

                        while ((i = fis.read(music)) != -1)
                            at.write(music, 0, i);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    at.stop();
                    at.release();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();