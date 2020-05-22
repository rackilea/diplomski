double[] micBufferData = new double[<insert-proper-size>];
    final int bytesPerSample = 2; // As it is 16bit PCM
    final double amplification = 100.0; // choose a number as you like
    for (int index = 0, floatIndex = 0; index < bytesRecorded - bytesPerSample + 1; index += bytesPerSample, floatIndex++) {
        double sample = 0;
        for (int b = 0; b < bytesPerSample; b++) {
            int v = bufferData[index + b];
            if (b < bytesPerSample - 1 || bytesPerSample == 1) {
                v &= 0xFF;
            }
            sample += v << (b * 8);
        }
        double sample32 = amplification * (sample / 32768.0);
        micBufferData[floatIndex] = sample32;
    }