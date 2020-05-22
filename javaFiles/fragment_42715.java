int bytesRead = bufferedInputStream.read(buffer, totalBytesRead, bytesRemaining);

    if (bytesRead == -1) {
        break;
     } else {
        bufferedOutputStream.write(buffer, totalBytesRead, bytesRead);
        totalBytesRead += bytesRead;
    }