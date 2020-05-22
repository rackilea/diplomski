private static int[] testResults = new int[5];

public static void main(String... args) throws Exception
{
    Scanner k = new Scanner(System.in);
    int testGrades = 0;

    for (int i = 0;i < testResults.length; i++)
    {
        System.out.print("Thank you, now please enter your grade on each test:     ");
        testResults[i] = k.nextInt();
        testGrades += testResults[i];
    }
    System.out.print("The original sequence is: \n   ");
    for (int i = 0;i < testResults.length; i++)
    {
        System.out.print(testResults [i] + ", ");
    }
    System.out.println();
    SortEm(testResults);
    System.out.print("The new sequence is : \n   ");
    for (int i=0; i < testResults.length; i++)
    {
        System.out.print (testResults[i] + ", ");
    }
    System.out.println();
    System.out.println("The average of all your tests is " + (testGrades / testResults.length));
}
private static void SortEm (int [] ar)
{
    int temp;
    for (int i = ar.length - 1; i > 0; i--)
    {
        for (int j = 0; j < i; j++)
        {
            if (ar[j] > ar[j + 1])
            {
                temp = ar[j];
                ar[j] = ar[j + 1];
                ar[j+1] = temp;
            }
        }
    }
}