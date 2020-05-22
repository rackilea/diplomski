InputStream b_in = new ByteArrayInputStream(resultArray);
try {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(
                "C:\\filename.bin"));
        dos.write(resultArray);
        AudioFormat format = new AudioFormat(8000f, 16, 1, true, false);
        AudioInputStream stream = new AudioInputStream(b_in, format,
                resultArray.length);
        File file = new File("C:\\file.wav");
        AudioSystem.write(stream, Type.WAVE, file);
        Logger.info("File saved: " + file.getName() + ", bytes: "
                + resultArray.length)