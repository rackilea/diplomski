int sum = 0;
for(int n : all the numbers){
    for(int i = 1; i*i<=n;i++){
        if(n%i == 0){
            if(i % 2 == 1)sum+=i;
            if((n/i) % 2 == 1)sum += (n/i);
        }
    }
}
return sum;