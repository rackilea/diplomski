byte[] byteBuffer = new byte[(int) inputFile.length()];
    DataInputStream dis = new DataInputStream(inputStream);
    dis.readFully(byteBuffer);
    dis.close();
    CipherOutputStream cos = new CipherOutputStream(outputStream, cipher);
    cos.write(byteBuffer);
    cos.close();