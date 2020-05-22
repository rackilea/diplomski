private void throttle() throws IOException {
      long limit= calculateMaxBytesPerSecond();
      long bytePerSec= getBytesPerSec();
    if (limit!=-1 && bytePerSec > limit) {

        long sleep_duration=((bytePerSec-limit)/limit)*1000;

      try {
          if(sleep_duration==0)
              Thread.sleep(1000);
          else
              Thread.sleep(sleep_duration);

        totalSleepTime += SLEEP_DURATION_MS;
      } catch (InterruptedException e) {
        throw new IOException("Thread aborted", e);
      }
    }
  }

private long calculateMaxBytesPerSecond() {
      switch (streamType) {
    case 0:
        if(connectionManager.getDownloadSpeedLimit()>0)
            return connectionManager.getDownloadSpeedLimit() / downloadManager.getTaskCount();
        else
            return -1;

    case 1:
        if(connectionManager.getUploadSpeedLimit()>0)
            return connectionManager.getUploadSpeedLimit() / uploadManager.getTaskCount();
        else
            return -1;
    }

    return Long.MAX_VALUE;
  }

public long getBytesPerSec() {
    long elapsed = (System.currentTimeMillis() - startTime) / 1000;
    if (elapsed == 0) {
      return bytesRead;
    } else {
      return bytesRead / elapsed;
    }
  }