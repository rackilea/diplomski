int count=0

while(true) {
  int score = readInt("enter the test score: ");
  if (score == SENTINEL) break;  
  total += score; 
  count++;
}