// Recursive:
int f(int n){ // i.e. n=2
  int[] stack = new int[1024]; // Example size, alternative an actual java.util.Stack could be used 
  int i=0;
  while(i >= 0){
    stack[i++] = n%2+1;
    n/=2;
    if(n < 1){
      while(i > 0){
        n = 3*n + stack[--i];
      }
      return n;
    }
  }
  return -1; // It should never come here, but the method need a return-statement
}