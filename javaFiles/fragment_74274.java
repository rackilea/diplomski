static int candy(int n,int m){
    if((n+n%m)/m>1){
        sum+=n/m+candy((n+(n%m))/m,m);
    }
    return sum;
}