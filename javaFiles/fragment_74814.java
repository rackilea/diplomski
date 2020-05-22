public void run() {
    bData = ByteBuffer.allocate(BufferElements);
    while (isRecording && !isInterrupted()) {
        int result = recorder.read(bData, 0, BufferElements);
        if (result > 0) {
            qArray.add(bData);
            SendAudio();
            bData = ByteBuffer.allocate(BufferElements);
        } else if (result == AudioRecord.ERROR_INVALID_OPERATION) {
            Log.e("Recording", "Invalid operation error");
            break;
        } else if (result == AudioRecord.ERROR_BAD_VALUE) {
            Log.e("Recording", "Bad value error");
            break;
        } else if (result == AudioRecord.ERROR) {
            Log.e("Recording", "Unknown error");
            break;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            break;
        }
    }
}