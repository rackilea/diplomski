Scanner input = new Scanner(new FileReader("C:/.../mrr569.fasta"));
int lines = 0;
int characters = 0;
int maxCharacters = 0;
int lineNo = 1;
int charsInSecondLine = 0;
String longestLine = "";

while (input.hasNextLine()) {
    String line = input.nextLine();
    lines++;
    characters += line.length();

    if (maxCharacters < line.length()) {
        maxCharacters = line.length();
        longestLine = line;
    }

    if(lineNo==2){
        charsInSecondLine=line.length();
    }
    lineNo++;
}
System.out.println(lines);
System.out.println(characters);
System.out.println(longestLine);
System.out.println(charsInSecondLine);