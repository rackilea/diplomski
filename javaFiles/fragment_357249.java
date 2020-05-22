audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                sampleRate, AudioFormat. CHANNEL_OUT_STEREO,
                AudioFormat.ENCODING_PCM_16BIT, generatedSnd.length,
                AudioTrack.MODE_STREAM);

        audioTrack.play();

    private class OutDACrunnable
        implements Runnable {

        public void run() {
            while (! done) {
                playTone();
                try {
                    Thread.sleep((int) (750 * duration));
                } catch (InterruptedException e) {
                    Log.e(MyTag, "OutDACrunnable: " + e.toString());
                }
            }
        }

    } // OutDACrunbable

    void playTone() {

    //      Log.d(MyTag, "playTone: start");

            audioTrack.write(generatedSnd, 0, generatedSnd.length);

            if (audioManager.isWiredHeadsetOn()) { } // use this later

    //      Log.d(MyTag, "playTone: done");

    } // playTone

    public static void genTone(double amp1, double amp2) {

//      Log.d(MyTag, "genTone: start");

        // convert to 16 bit pcm sound array
        // assumes the sample buffer is normalised.
        int idx = 0;
        for (int i = 0; i < numSamples; i++) {
            // scale to maximum amplitude
            // in 16 bit wav PCM, first byte is the low order byte, first short is left ch
            short val = (short) ((amp1 * 32767));
            generatedSnd[idx++] = (byte) (val & 0x00ff);
            generatedSnd[idx++] = (byte) ((val & 0xff00) >>> 8);
            val = (short) ((amp2 * 32767));
            generatedSnd[idx++] = (byte) (val & 0x00ff);
            generatedSnd[idx++] = (byte) ((val & 0xff00) >>> 8);

        }
//      Log.d(MyTag, "genTone: done");
    }