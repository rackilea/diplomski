long sum0 = 0, sum1 = 0;
    for (int i=0; i<data.length; i+=2) { // assuming even `data.length`
        sum0 += data[i+0];
        sum1 += data[i+1];
    }
    blackhole = sum0 + sum1;