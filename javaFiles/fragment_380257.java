import java.util.Scanner;


public class TriangleOne {


    private String word;


    public TriangleOne()
    {
        word="";
    }

    public TriangleOne(String s)
    {
    word = s;
    }

    public void setWord(String s)
    {
    word = s;
    }

    public void print( )
    {
        int length = word.length();
        for(int i = length; i >= 0 ; i --) {
            System.out.println(word.substring(0, i));
        }
    }
    public static void main ( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a word :: ");
        String a =keyboard.nextLine();
        TriangleOne test = new TriangleOne(a);
        test.print();//modification for method call
        System.out.println("");
}}