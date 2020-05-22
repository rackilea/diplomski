while (true) {
    int bytesRead = is.read(readBuf);
    if (bytesRead < 0) {
        break;
    }
    os.write(readBuf, 0, bytesRead);
  }