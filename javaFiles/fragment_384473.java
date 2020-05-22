int fibo(int i){
  if(i == 0) return 0;
  if(i == 1) return 1;
  if( fibMap[i] == 0)
    fibMap[i] = fibo(i-1)+fibo(i-2);      //Cache result
  return fibMap[i];
}