public class Exercises {

    public static void main(String[] Args) throws FileNotFoundException {

      // scanner splits on all whitespace characters by default, so it needs
      // to be configured with a different regex in order to preserve newlines
      Scanner inputFile = new Scanner(new File("misc/duplicateLines.txt"))
          .useDelimiter("[ \\t]");

      printDuplicates(inputFile);
    }

    public static void printDuplicates(Scanner input){

        int lastWordCount = 0;
        String lastWord = null;

        while(newInput.hasNext()){

            //read next token into String
            String nextWord = newInput.next();

            // reset counters on change and print out if count > 1
            if(!nextWord.equals(lastWord)) {
                if(lastWordCount > 1) {
                    System.out.println(lastWord + "*" + lastWordCount);
                }
                lastWordCount = 0;
            }

            lastWord = nextWord;
            lastWordCount++;
        }

        // print out last word if it was repeated
        if(lastWordCount > 1) {
            System.out.println(lastWord + "*" + lastWordCount);
        }
    }
}