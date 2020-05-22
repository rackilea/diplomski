List<Integer> numbers = new ArrayList<>();
System.out.println("Guess a number");
int a = 45;
Scanner scan = new Scanner(System.in);
int input = scan.nextInt();
double total = 0;

for (int i=0; i!=999; i++) {
    input = scan.nextInt();

    if (input != a)
    {
        System.out.println("You guessed wrong. Guess again");
        numbers.add(input);
    }
    else if (input == a){
        numbers.add(input);
        System.out.println("You guessed right");
        break;
    }
} 
for (int i = 0; i < numbers.size(); i++)
{
    total += numbers.get(i);
}
System.out.println("The average of your inputted numbers is "+total/numbers.size());