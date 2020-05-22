public class Word {

private String name;
private int number;

public Word() {
    name = "";
}

public void addChar(char ch) {
  name += ch;
  number++;
}

public String toString() {
  return name; 
}

public int length() {
  return number;
}

public static void main(String[] args) {
    Word myWord = new Word();
    myWord.addChar('H');
    System.out.println(myWord);
    myWord.addChar('e');
    myWord.addChar('l');
    myWord.addChar('l');
    myWord.addChar('o');
    System.out.println(myWord);
    System.out.println(myWord.length());

}
}