int bytesRead = bufferedInputStream.read(buffer);

    if (bytesRead == -1) {
        break;
     } else {
        bufferedOutputStream.write(buffer, 0, bytesRead);
        totalBytesRead += bytesRead;
    }