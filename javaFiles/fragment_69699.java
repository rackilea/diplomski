public static void main(String[] args) {

    String paragraph;
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a paragraph: ");
    paragraph = input.nextLine();
    paragraph = paragraph.trim();

    String reversedParagraph = new StringBuilder(paragraph)
            .reverse().toString().toLowerCase();

    StringBuilder out = new StringBuilder();
    for (String sentence : reversedParagraph.split(" *\\.")) {
        if (!sentence.equals("")) {
            sentence += ". ";
            out.append(Character.toUpperCase(sentence.charAt(0))
                    + sentence.substring(1));
        }
    }
    System.out.println(out.toString().trim());

}