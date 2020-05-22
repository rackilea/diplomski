public static void main(String[] args) 
{
    Scanner in = new Scanner(System.in);

    System.out.print("How many random numbers from 0 to 999? ");
    int amount = in.nextInt();
    int lowerCounter=0;
    int higherCounter=0;
    List<Integer> lowerList = new ArrayList<Integer>();
    List<Integer> higherList = new ArrayList<Integer>();

    int[] numbers = new int[amount];
    System.out.print("Here is the random numbers: ");
    for (int i = 0; i < numbers.length; i++) 
    {
        numbers[i] = (int) Math.floor(Math.random()*1000);
        System.out.print(numbers[i] + " ");
        if (numbers[i] <= 499) {
            lowerCounter++;
            lowerList.add(numbers[i]);
        }
        else {
            higherCounter++;
            higherList.add(numbers[i]);
        }
    }
    System.out.println("");


    System.out.print("These ["+lowerCounter+"] numbers are from 0 to 499: ");
    for (int i:lowerList) 
    {
        System.out.print(i + " ");    
    }
    System.out.println("");


    System.out.print("These ["+higherCounter+"] numbers are from 500 to 999: ");
    for (int i:higherList) 
    {
        System.out.print(i + " ");    
    }
}