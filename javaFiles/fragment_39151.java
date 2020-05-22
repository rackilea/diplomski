Call Stack goes this way:

numbers(n) // n = 5
{
  n>0 ? YES
  Print n -- Print 5
  call numbers(n-2) //n-2 = 3

    numbers(n) // n=3
    {
      n>0 ? YES
      Print n -- Print 3
      call numbers(n-2) //n-2 = 1

        numbers(n) // n=1
        {
          n>0 ? YES
          Print n -- Print 1
          call numbers(n-2) //n-2 = -1

            numbers(n) // n=-1
            {
              n>0 ? NO As Per the code, does nothing
            }
          Print n -- Print 1
        }
     Print n -- Print 3
   }
  Print n -- Print 5
}