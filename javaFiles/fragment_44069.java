public double mode() {
        // Sort array
        Arrays.sort(data);

        double maxValue = 0.0, maxCount = 0.0;
        for (int i = 0; i < data.length; ++i) {

            // Count number of elements with same value
            int count = 0;
            int index = i;  
            while (index < data.length) {
                if (data[i] == data[index]) {
                    count++;
                    index++;
                } else {
                    break;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = data[i];
            } else if (count == maxCount) {
                maxCount = count;
                maxValue = 0.0;
            }
        }

        return maxValue;
    }