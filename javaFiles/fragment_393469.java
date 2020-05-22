public class MyClass{

LinkedList<String> wordlist;

public MyClass(){
    String[] words = { "Welcome", "Different", "Teenager", "Transfer", "Italian", 
               "Timber", "Toxic", "Illiterate", "Irate", "Moderate", "Transportation", "Attention" };
    wordlist = new LinkedList<String>();
    for (String i : words) 
        wordlist.add(i);
    Collections.shuffle(wordlist);
}

public void useNextWord(){
    tvWord.setText("");
    tvWord.setText(wordlist.pollLast());
}