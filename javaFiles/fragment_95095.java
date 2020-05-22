double rate = rateInterest / 100;
 double sum = 0;
 for(int x = 0; x <= yrSaving; x++){
   sum += accBalance * rate;
 }
 return sum;