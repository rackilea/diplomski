static void caller()
{
  for (int t = 0; t < MAX; t++)
  for (int x = 0; x <= t; x++)
  for (int y = 0; y <= (t-x); y++)
  {
     int z = (t-x-y);
     printAllPossibleSigns(0, x, y, z);
  }
}