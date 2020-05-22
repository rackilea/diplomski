try {
        short[] buffer = new short[bufferSize];
        int bufferReadResult;
        do {


            bufferReadResult = audio.read(buffer, 0, bufferSize);
            for (int i = 0; i < bufferReadResult; i++){
                if (buffer[i] > lastLevel) {
                    lastLevel = buffer[i];
                }
            }
            // if sound level is over 20000 start voice recognition
            if (lastLevel > 20000){
                lastLevel = 0;
                startVoiceRecognitionActivity();
                Thread.sleep(5000);
            }

        } while (bufferReadResult > 0 && audio.getRecordingState() == AudioRecord.RECORDSTATE_RECORDING);

    } catch (Exception e) {
        e.printStackTrace();
    }
}