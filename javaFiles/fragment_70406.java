public static void main(String[] args)
{

    Scanner input = new Scanner(System.in);

    System.out.println("Enter some words (all on one line, separated by spaces):");
    String line = input.nextLine();
    String[] words = line.split(" +");
    ArrayList<String> a = new ArrayList<String>();

    for(int i=0; i<words.length; i++)
    {
        a.add(words[i]);
    }

    System.out.println("The words are stored in an ArrayList");
    System.out.println("The ArrayList is "+a);

    System.out.print("\nEnter a number");

    int len = input.nextInt();

    for(int j=0;j<a.size(); j++)
    {
        String b =a.get(j);

        if(b.length()<len)
        {

            a.remove(j);
            j--;
        }

    } 

    System.out.println("The ArrayList is "+a);
}