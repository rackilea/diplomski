// this is your function
static void func(int x, int y)
{
  System.out.println("x = "+x+", y = "+y);
}

// this calls func for all possible combinations of signs of the variables in arr
static void allPossibleSigns(int pos, Integer... arr)
{
  if (pos == arr.length)
  {
     func(arr[0], arr[1]); // not really generic
  }
  else
  {
     allPossibleSigns(pos+1, arr);
     arr[pos] = -arr[pos];
     if (arr[pos] != 0)
        allPossibleSigns(pos+1, arr);
  }
}

static void caller()
{
  for (int t = 0; t < MAX; t++)
  for (int x = 0; x <= t; x++)
  {
     int y = (t-x);
     allPossibleSigns(0, x, y);
  }
}