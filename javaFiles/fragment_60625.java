static Scanner list1s;
static  Scanner list2s;
public static void readLists(ArrayList <String> list1, ArrayList <String> list2)

{

    try
    {
        list1s = new Scanner(new File("list1.txt"));
        list2s = new Scanner(new File ("list2.txt"));
    }
    catch(FileNotFoundException ex)
    {
        System.out.println("File not found!\n");
    }
// Your code
}