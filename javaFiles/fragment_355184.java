long n = sc.nextLong();
int k = 0x02;
int l = (int) (Math.sqrt(n)+1);
while(k < n && k <= l) {
    if(n%k == 0) {
        n /= k;
    } else {
        k++;
    }
}
return Math.max(n,k);