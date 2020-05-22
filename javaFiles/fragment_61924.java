public static void main(String[] args)
{
    Scanner in = new Scanner(System.in);                                                    
    System.out.print(" How many random numbers between 0 – 999 do you want? "); 
    int varde = in.nextInt();   
    System.out.println(" ");
    System.out.println(" this is your numbers:");
    Random randomGenerator = new Random();

    int randomArray[]=new int[varde];

    for(int i = 0; i<varde; i++)
    {   
        randomArray[i] = randomGenerator.nextInt(1000); 
        System.out.print(randomArray[i]);
    }

    int largest = randomArray[0]; 
    for(int x=0; x<randomArray.length; x++){ 
        if(randomArray[x]>largest)
            largest =  randomArray[x]; 
    }
    System.out.println("Largest no is: "+largest); 

    List<Integer> numbersGreaterThanHalf = new ArrayList<Integer>();
    List<Integer> numbersLowerThanHalf = new ArrayList<Integer>();

    for(int x=0; x<randomArray.length; x++){ 
        if(randomArray[x]>499) 
            numbersGreaterThanHalf.add(randomArray[x]);
        else
            numbersLowerThanHalf.add(randomArray[x]);
    }

    System.out.println("these " + numbersLowerThanHalf.length() + "numbers is between 0 – 499");
    for(Integer number: numbersLowerThanHalf)
    {
       System.out.print(number + " ");
    }

    System.out.println("these " + numbersGreaterThanHalf.length() + "numbers is between 500 – 999");
    for(Integer number: numbersGreaterThanHalf)
    {
       System.out.print(number + " ");
    }
}