public int getMaxRainfallIndex(double[] rainfall) {
        int max = 0;
        for (int i = 1; i < rainfall.length; i++)
            if (rainfall[i] > rainfall[max]) {
                max = i;
            }
        return max;
    }