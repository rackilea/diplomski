byte data[] = new byte[1024];
    long total = 0;
    int count, latestPercentDone;
    int percentDone = -1;
    while ((count = input.read(data)) != -1) {
        total += count;
        latestPercentDone = (int) Math.round(total / fileLength * 100.0);
        if (percentDone != latestPercentDone) {
            percentDone = latestPercentDone;
            publishProgress(percentDone);
        }
        output.write(data, 0, count);
    }