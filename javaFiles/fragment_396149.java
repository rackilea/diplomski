import java.util.Random;

public class Hangman{
    String words[]={"notions","measure","product","foliage"};



    public String selectGameWord(int x)
    {
        String sentence= words[x]; 
        return sentence; 
    }
    public static void main (String[] args){
        System.out.println("Welcome to Hangman!:"); 
        Random rand=new Random(); 
        Hangman myhangman= new Hangman();
        int n= rand.nextInt(myhangman.words.length);        
        String word= myhangman.selectGameWord(n); 
        System.out.println(word);
    }
}