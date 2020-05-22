public int countOdds()
{
  int oddCount=0;
  for(int i = 0; i < list.size(); i++){
      if(Number.isOdd()== true){
          oddCount++;
      }
  }
  return oddCount;
}