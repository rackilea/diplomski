for (int j = i - 1; j >= 0; j--) {
        if (binaryNum[j] == 0) {
            int ctr = 0;
            while (binaryNum[j] == 0) {
                ctr++;
                j--;
            }
            al.add(ctr);
        }
    }