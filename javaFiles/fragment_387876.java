public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a line of words seperated by spaces ");
    String userInput = input.nextLine();
    String[] words = userInput.split(" ");
    int n = words.length();
    System.out.print("Enter lookup word - N");
    int askedFor = input.nextInt();
    if (askedFor > n) {
        //your logic for this condition
        return;
    }
    String nthWord = words[askedFor-1];
    if (nthWord.length() < askedFor) print(nthWord.charAt(nthWord.length()-1));
    else print(nthWord.charAt(askedFor-1));
    input.close();
}