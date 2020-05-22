int sum = 0;
int currentStart = 0;

int bestSum = 0;
int bestStart = 0;
int bestEnd = 0;

for (int i = 0; i < N; i++) {
    sum += a[i];
    if (sum > bestSum) {
        bestSum = sum; 
        bestStart = currentStart; 
        bestEnd = i;
    }

    if (sum < 0) {
        sum = 0; 
        currentStart = i + 1;
        continue;
    }

    //Our sequence length has become equal to M
    if (i - currentStart + 1 == M) { 
        do {
           sum -= a[currentStart]; 
           currentStart++;  
        } while ((sum < 0 || a[currentStart] < 0) && (currentStart <= i)); 
    }
}