Scanner input = new Scanner(System.in);

System.out.print("Enter the essay: ");

String essay = input.nextLine();
int sentenceCount = essay.split("\\S(\\s*[.!?])+(?!\\d)").length;

while (sentenceCount < 2) {
    System.out.print("Incorrect input! Your essay must contain at least 2 sentences, please try again: ");
    essay = input.nextLine();
    sentenceCount = essay.split("\\S(\\s*[.!?])+(?!\\d)").length;
}

System.out.printf("Your essay contains %d sentences.", sentenceCount);