public class SortingString {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<String>();

        while (in.hasNext()) {
            System.out.println("Enter the word:");
            words.add(in.nextLine());
            System.out.println("Do you want to continue? (y/n)");
            in.hasNext();
            if (!in.nextLine().equalsIgnoreCase("y")) {
                break;
            }
        }
        Collections.sort(words);

        in.close(); // Don't forget to close the stream !!
    }
}