public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    String[] myPhrase = keyboard.nextLine().split(" ");
    HashMap<String, Integer> myWordsCount = new HashMap<String, Integer>();
    for (String s : myPhrase){
        if (myWordsCount.containsKey(s)) myWordsCount.replace(s, myWordsCount.get(s) + 1);
        else myWordsCount.put(s, 1);
    }
    System.out.println(myWordsCount);
}