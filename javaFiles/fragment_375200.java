String c = "ABC"; // pointing to 'ABC' in pool. 

for(int i=0; i< 10000; i++) {
  c = ""+i; // each iteration add new value in pool. and pervious values has no pointer  

}