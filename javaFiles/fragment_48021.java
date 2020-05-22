public static void search (int arr[]) {
    Scanner in = new Scanner(System.in);
    int key;
    int N = arr.length;
    int element = 0;

    System.out.println("Enter the number that you want to search: ");
    key = in.nextInt();
    boolean found = false;
    while (element < N) 
    {
        if(key == arr[element]){
            found = true;
            break;
        }
        element++;
    }

    if(!found)
        {System.out.println("not found, try again...");}
    else 
        {System.out.println("found, it's in index # " + element);}
}
public static void main (String[]args)
{
    int arr[] = { 2, 3, 4, 5, 7, 11, 34, 37, 77 };
    search(arr);
}