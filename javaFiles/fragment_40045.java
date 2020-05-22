int[] a={3,2,1};
for(int i=0; i<2; i++){
    int small=a[i];
    int t = i;
    for(int j=i+1; j<3; j++){
        if(a[j]<small){
            small=a[j];
            t=j;
        }
    }
    if (i != t) {
        int tmp =a[i];
        a[i]=small;
        a[t]=tmp;
    }
}