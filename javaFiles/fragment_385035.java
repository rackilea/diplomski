static int totalNumbers(int a)
  { 
    if(a <= 0)
      return 0;
    else
    {
      return (a % 10) + totalNumbers(a/10);
    }
  }