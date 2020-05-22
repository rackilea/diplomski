public void getValidSampleRates() {
    for (int rate : new int[] {8000, 11025, 16000, 22050, 44100}) {  // add the rates you wish to check against
        int bufferSize = AudioRecord.getMinBufferSize(rate, AudioFormat.CHANNEL_CONFIGURATION_DEFAULT, AudioFormat.ENCODING_PCM_16BIT);
        if (bufferSize > 0) {
            // buffer size is valid, Sample rate supported

        }
    }
}