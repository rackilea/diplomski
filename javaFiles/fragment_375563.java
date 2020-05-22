public static void play(ArrayList<String> files){
    byte[] buffer = new byte[4096];
    for (String filePath : files) {
        File file = new File(filePath);
        try {
            AudioInputStream is = AudioSystem.getAudioInputStream(file);
            AudioFormat format = is.getFormat();
            SourceDataLine line = AudioSystem.getSourceDataLine(format);
            line.open(format);
            line.start();
            while (is.available() > 0) {
                int len = is.read(buffer);
                line.write(buffer, 0, len);
            }
            line.drain();
            line.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}