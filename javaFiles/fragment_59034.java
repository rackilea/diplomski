Process proc = Runtime.getRuntime().exec("...");

    OutputStream standardInputOfChildProcess = proc.getOutputStream();
    InputStream dataFromFile = new FileInputStream("theFileWithTheData.dat");

    byte[] buff = new byte[1024];
    for ( int count = -1; (count = dataFromFile.read(buff)) != -1; ) {
        standardInputOfChildProcess.write(buff, 0, count);
    }