for (int i = 0; binaryNum1[i] != -1; ++i) {  
        for (int j = 0; binaryNum2[j] != -1; ++j) {  
            resultBinaries[i + j] += binaryNum1[i] * binaryNum2[j] % 2;  
            resultBinaries[i + j] %= 2;  
        }  
    }