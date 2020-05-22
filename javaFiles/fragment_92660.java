public static void main(String[] args)
{
System.out.println(" The purpose of this program is to calculate the speed of sound through several mediums.\n The program user will input a distance in feet followed by a mediumd and the program will output the speed in feet per second and miles per hour\n");
//declare variables

Scanner keyboard = new Scanner(System.in);

final double Air = 1126.1;

final double Water = 4603.2;

final double Steel = 20013.3;

final double Earth = 22967.4;

double OneFootPerSecond = .68181818182;

double Distance;

double AirSpeed;

double WaterSpeed;

double SteelSpeed;

double EarthSpeed;

boolean shouldContinue = true;

while (shouldContinue == true)
{

  System.out.print(" What is the distance in feet:");
  //ask the user to input variables


  while (!keyboard.hasNextDouble())
  {
    System.out.println("Please enter a valid numeric value, try again: ");
    keyboard.next();
  }

  Distance = keyboard.nextDouble();

  System.out.print("Input the media: Air, Water, Steel, or Earth: ");
  String Input = keyboard.next();

  switch (Input.toLowerCase())
  {

    case "air":
      AirSpeed = Distance / Air;
      System.out.print("\n \nThe time to for sound to travel ");
      System.out.print(Distance);
      System.out.print(" feet through AIR" + "\n");
      System.out.printf("%.6f", AirSpeed);
      System.out.print(" seconds or ");
      System.out.printf("%.1f", OneFootPerSecond * Air);
      System.out.println(" miles per hour.");

      break;

    case "water":
      WaterSpeed = Distance / Water;
      System.out.print("\nThe time to for sound to travel ");
      System.out.print(Distance);
      System.out.print(" feet through WATER" + "\n");
      System.out.printf("%.6f", WaterSpeed);
      System.out.print(" seconds or ");
      System.out.printf("%.1f", OneFootPerSecond * Water);
      System.out.println(" miles per hour.");

      break;

    case "steel":
      SteelSpeed = Distance / Steel;
      System.out.print("\nThe time to for sound to travel ");
      System.out.print(Distance);
      System.out.print(" feet through STEEL" + "\n");
      System.out.printf("%.6f", SteelSpeed);
      System.out.print(" seconds or ");
      System.out.printf("%.1f", OneFootPerSecond * Steel);
      System.out.println(" miles per hour.");


      break;

    case "earth":
      EarthSpeed = Distance / Water;
      System.out.print("\nThe time to for sound to travel ");
      System.out.print(Distance);
      System.out.print(" feet through EARTH" + "\n");
      System.out.printf("%.6f", EarthSpeed);
      System.out.print(" seconds or ");
      System.out.printf("%.1f", OneFootPerSecond * Earth);
      System.out.println(" miles per hour.");

      break;
    default:
      System.out.println("Invalid. Re-run the program. ");
      break;
  }
  shouldContinue = promptForContinue(keyboard);
 }

}

private static boolean promptForContinue(final Scanner keyboard)
{
 boolean isValid = false;
 String userInput = "";
 do
 {
   System.out.print("Continue (Yes/No) ?");
   userInput = keyboard.next();

   isValid = userInput.matches("Yes|No");

   if (!isValid)
   {
    System.out.println("\nInvalid entry.");
   }
 }
 while (!isValid);

 return userInput.equals("Yes") ? true : false;
}