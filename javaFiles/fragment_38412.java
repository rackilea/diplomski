public class CoffeeAndShots{

    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);

        int numberOfCoffees = 5;
        int numberOfShots = 5;
        int[] coffeeShots = new int[numberOfCoffees];

        for(int i = 0; i < numberOfCoffees; i++)
            coffeeShots[i] = -1;

        for(int i = 0; i < numberOfCoffees; i++){
            int input;
            while(coffeeShots[i] < 0){
                System.out.println("How many shots for coffee cup " + (i + 1) + "?");
                input = keyboard.nextInt();
                if(input > numberOfShots)
                    System.out.println("You don't have that many shots");
                else{
                    coffeeShots[i] = input;
                    numberOfShots = numberOfShots - input;
                }
            }
        }

        for(int i = 0; i < numberOfCoffees; i++)
            System.out.println(coffeeShots[i] + " shots for coffee cup " + (i + 1));
    }


}