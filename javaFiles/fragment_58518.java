BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


int totalnum, number, num1, max, min;

System.out.println("How many integers are you entering?");
totalnum = Integer.parseInt(input.readLine());

System.out.println("Enter an integer");
number = Integer.parseInt(input.readLine());
max = number;
for (int ctr = 2; ctr <= totalnum; ctr++)
{
    number = Integer.parseInt(input.readLine());
    if (number > max){
        max = number;
    }
}
System.out.println("The max is "+ max);