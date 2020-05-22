for (int j = i - 1; j >= 0; j--) {
        if (binaryNum[j] == 0) {
            k = j;
            do {
                ctr++;
                k++;
            } while (binaryNum[k] == 0);
            al.add(ctr);
            ctr = 0;
        }
    }