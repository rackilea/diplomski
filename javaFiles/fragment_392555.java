for (i = 0; i < a.length; i++)
{
      if (a[i] == target)
        count = count + 1;
        spotIndex = i;     // spotIndex comes in for loop but not in if condition.
                           // and this gets modified at every step in loop.
                           // simply assigning value of i to it.
}