int counter = 0;
for (i = 0; i < n; i++) 
{
  for (j = 0; j < n; j++) 
  {
    System.out.print(counter);
    if(++counter > 9) {
      counter = 0;
    }
  }
  System.out.println();
}