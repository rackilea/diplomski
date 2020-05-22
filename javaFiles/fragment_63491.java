public static void main(String[] args)
{
    int num = 0;
    int temp = 0;

    Scanner sc = new Scanner(System.in);
            num = sc.nextInt();

    int place = 1;
    int output = 0;

    while(num != 0) {
       temp = num % 2;
       num = num / 2;    

       output += (place*temp);
       place *=10;
    }

    System.out.print(""+output);
}