public class Loop {

public static void main(String[] args) {

 int x = 0;
 int y = 50;

 do {
  System.out.println("output is = " + y);


  if (x % 2 == 0)
   y -= 1;
  else
   y -= 2;
  x++;

 }

 while (y >= 40);
}