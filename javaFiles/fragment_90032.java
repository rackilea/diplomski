boolean prime =true.
for (int i = 2; i <= Math.sqrt(num); i++){// less than equal to sqrt num is good enough.
        if (num % i == 0){
            prime=false;
            break; // no more checks needed
   }    
}
if (prime && (num>1)){ // to cover case of num=0 and num=1
     System.out.println(i+" is Prime");
}
else{
     System.out.println(i+" is NOT Prime");
}