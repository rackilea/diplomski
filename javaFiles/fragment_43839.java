public static void main (String [] args)
{
    System.out.println("\nThe Original List:");
    System.out.println("-------------------\n");
    for (int i = 0; i < 50; i++)
    {
        num = storage.myRand();
        tim = storage.tellTime();
        storage.addTo(num, tim);
    }

    System.out.println(storage);
    System.out.println("\n\n");
    System.out.println("The Sorted List:");
    System.out.println("-------------------\n");

    storage.sortNode();

    System.out.println(storage);
}