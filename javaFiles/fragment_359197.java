try {
        int size=0;
        for (byte[] bs : rescievedBytes) {
            size+=bs.length;
        }
        byte[] decodedData=new byte[size];
        int i=0;
        for (byte[] bs : rescievedBytes) {
            for (int j = 0; j < bs.length; j++) {
                decodedData[i]=bs[j];
            }
        }
        getWavFile(getNextFile(), decodedData);
    } catch (IOException|OutOfMemoryError e) {
        e.printStackTrace();
    }

private void getWavFile(File outFile, byte[] decodedData) throws IOException {
    AudioFormat format = new AudioFormat(8000, 16, 1, true, false);
    AudioSystem.write(new AudioInputStream(new ByteArrayInputStream(
            decodedData), format, decodedData.length), AudioFileFormat.Type.WAVE, outFile);
}