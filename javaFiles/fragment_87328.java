int power(int x, int y, int p){
int res = 1;  
x = x % p;  
  while (y > 0){
      if (y % 2 == 0)
          res = (res*x) % p;
      y /= 2;
      x = (x*x) % p;  
  }
  return res;
}