if(n%2!=0) return 0;
for(i=2;i<sqrt(n);++i) {
  int div=i*(i+1);
  if( n % div ==0) { return 1; }
}
return 0;