Queue<byte[]> qArray = new LinkedList<byte[]>();
recordingThread = new Thread(new Runnable() {

    @Override
    public void run() {
        while (isRecording) {
            bData = new byte[BufferElements];
            recorder.read(bData, 0, BufferElements);
            qArray.add(bData);
            if (AudioRecord.ERROR_INVALID_OPERATION != 0) {
                SendAudio();
            }
        }
    }
}, "AudioRecorder Thread");
recordingThread.start();