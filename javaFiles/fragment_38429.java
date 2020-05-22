Scanner keyboard = new Scanner(System.in);
int startr, endr;
boolean good = false;
do
{
  System.out.println("Enter the Starting Number of the Range: ");
  startr = keyboard.nextInt();
  if(startr % 10 == 0 && startr >= 0)
    good = true;
  else
    System.out.println("Numbers is not divisible by 10");
}
while (!good);

good = false;
do
{
    System.out.println("Enter the Ending Number of the Range: ");
    endr = keyboard.nextInt();
    if(endr % 10 == 0 && endr <= 1000)
      good = true;
    else
      System.out.println("Numbers is not divisible by 10");
}
while (!good);

// do stuff