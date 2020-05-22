int eyes[] = new int[] { 0,0,0,0,0,0 };

for ( int i = 1; i <= NUMBER_OF_ROLLS; i++ )
{
   int y = rand.nextInt(6) + 1;
   eyes[y] ++;
}