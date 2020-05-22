int count = 0;
  while (count < size) {
      int bytesRead = is.read(bytes, count, bytes.length - count);
      if (bytesRead == -1) {
           throw EOFException("didn't get a complete file");
      }
      count += bytesRead;
  }