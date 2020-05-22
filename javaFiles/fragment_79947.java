String[] flowerName = {"Pentunia", "Pansy", "Rose", "Violet", "Carnation"};
Double[] flowerPrice = {.50d, .75d, 1.50d, .50d, .80d};

System.out.println("What kind of flower would you like?");

Scanner keyboard = new Scanner(System.in);
String strFlowerIn = keyboard.nextLine();
int index = Arrays.asList(flowerName).indexOf(strFlowerIn);

System.out.println("How many would you like?");
int intFlowerNumIn = keyboard.nextInt();
decimal price = flowerPrice[index];
decimal total = price * intFlowerNumIn;

System.out.println("Total price: " + total);