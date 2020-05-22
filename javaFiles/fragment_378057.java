public void countUp(int start, int end){
 if(start>=end){
   return;
 }
 System.out.println(start++);
 countUp(start,end);
}