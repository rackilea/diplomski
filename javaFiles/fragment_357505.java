int[] odds= new int[numberOfOdds];
int i = 0;

for (int j = -6; j <= 38; j++)
{
  if(j % 2 == 1)
  {
      odds[i++] = j;
   }
}