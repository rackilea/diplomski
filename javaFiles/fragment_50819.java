while(a>0){
    digit=a%10;
    if(digitIsUnique(digit)){
        arr[j]=digit;
        j++;
    }
}