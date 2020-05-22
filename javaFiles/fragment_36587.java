names[4] = "bob", "mark", "james", "frank";

for (int i = 0; i < 4; i++)
{

  for(int k = 0; k < i; k++)
  {
    System.out.print(" ");
  }

  System.out.println("Hello, my name is " + names[i]);
}