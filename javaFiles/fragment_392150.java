int x;
int main() 
{
  {
    int x = 0;
    {
      extern int x;
      x = 1;
    }
    printf("%d\n", x); // prints 0
  }
  printf("%d\n", x); // prints 1
  return 0;
}