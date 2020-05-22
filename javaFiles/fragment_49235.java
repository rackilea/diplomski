int i, num=0, num2=0;
for(i=0; i<=23; i++) {
    if(result[i] == 1) {
        num++;
    }
}
int[] Time = new int[num-1];
for(i=0; i<=23; i++) {
    if(result[i] == 1) {
        Time[num2]=i;
        num2++;
    }
}