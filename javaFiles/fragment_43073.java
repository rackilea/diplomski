int n = 0;
int K = 0;
double Sum = 0;
double Sum_sqr = 0;
do { 
    System.out.println("Enter positive values, enter -1 to end");
    x = input.nextInt(); 
    if (x == -1)
    {
        break;
    }
    if ( n == 0 ) K = x;
    n++;
    Sum += (x - K);
    Sum_sqr += (x - K) * (x - K);
} while (x != -1);
double mean = K + Sum / n;
double varPop = (Sum_sqr - (Sum*Sum)/n) / (n);
double varSample = (Sum_sqr - (Sum*Sum)/n) / (n-1);
double devPop = Math.sqrt(varPop);
double devSample = Math.sqrt(varSample);