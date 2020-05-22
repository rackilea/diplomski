public class Assignment3
{
public static void main(String[] args)
throws FileNotFoundException {
    Scanner f = new Scanner( new File("README.txt"));
    int[] intArray = punctuation(f);
    System.out.println("The word the appears: "+ intArray[0] +" times");
    System.out.println("The word be appears: "+ intArray[1] +" times");
    System.out.println("The word to appears: "+ intArray[2] +" times");
}
public static int[] punctuation(Scanner f){
    ArrayList<String> tokens = new ArrayList();
    while (f.hasNext()){
        String currentToken = f.nextLine();
        currentToken = currentToken.replace("-","")
        .replace("?","")
        .replace("!","")
        .replace(",","")
        .replace(".","")
        .replace(":","")
        .replace(";","")
        .replace("\'","")
        .replace("\"","");
        if (currentToken.length()>0){
            currentToken = currentToken.toLowerCase();
            tokens.add(currentToken);
        }

    }
    return  wordCheck(tokens, f);
}
public static int[] wordCheck(ArrayList<String> tokens, Scanner f){
int word1Count = 0;
int word2Count = 0;
int word3Count = 0;
for(String s : tokens){
    boolean word1 = s.contains("the");
    if(word1 == true){
        word1Count++;
    }
    boolean word2 = s.contains("be");
    if(word2 == true){
        word2Count++;
    }
    boolean word3 = s.contains("to");
    if(word3 == true){
        word3Count++;
    }
}
int intArray[];
intArray = new int[3];
intArray[0] = word1Count;
intArray[1] = word2Count;
intArray[2] = word3Count;
return intArray;
   }
}