public int[] getRandomArr()
{
  int randomValues [] = new int [20];
  Random random = new Random();
  for(int j=0; j<20; j++)
  {
     randomValues[j] = random.nextInt(100);
  }
  return randomValues;
}