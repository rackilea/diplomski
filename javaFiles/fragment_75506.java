int x = 5;
int originalX = x;
int a = x++;
int b = x++;
int c = x++;
x = originalX + a * b * c;
System.out.println("x = " + x); //215