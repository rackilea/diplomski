import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

class TestApp{
    final static char[][] DIG_CHAR = {{}, {}, {'A', 'B', 'C'}, {'D', 'E', 'F'},
    {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'Q', 'R', 'S'},
    {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};

    public static void main(String[] args) throws IOException {

        String s1 = "telephone.txt";
        String s2 = "sample.txt";

        Process(s1, s2);
    }

    public static void Process(String s1, String s2) throws IOException {

        int size43 = count(s2, 3);
        int size44 = count(s2, 4);
        int size47 = count(s2, 7);
        /////
        System.out.println("lines of 3: "+size43 );
        System.out.println("lines of 4: "+size44 );
        System.out.println("lines of 7: "+size47 );
        /////

        String[] WordsOf3 = store(s2, size43, 3);
        String[] WordsOf4 = store(s2, size44, 4);
        String[] WordsOf7 = store(s2, size47, 7);
        /////
        System.out.println("lines of 3" );
        for(int i = 0; i<size43; i++){
            System.out.println( WordsOf3[i] );
        }
        System.out.println("lines of 4" );
        for(int i = 0; i<size44; i++){
            System.out.println( WordsOf4[i] );
        }
        System.out.println("lines of 7" );
        for(int i = 0; i<size47; i++){
            System.out.println( WordsOf7[i] );
        }
        /////

        String[] s = Char2Dig(WordsOf3);
        String[] p = Char2Dig(WordsOf4);
        String[] q = Char2Dig(WordsOf7);

        Print3(WordsOf3, s, s1);
        Print4(WordsOf4, p, s1);
        Print7(WordsOf7, q, s1);

    }

    /** Single method that returns the number of lines of given number of char
    *   With this single method, no need to write ThreeCharacters, FourCharacters
    *   and SevenCharacters
    */
    public static int count(String fName, int nChar) throws IOException {

        Scanner in = new Scanner(new File(fName));
        int count = 0;
        String tmp; // Note the tmp variable, so that we do not advance twice

        while (in.hasNextLine()) {
            if (in.nextLine().length() == nChar) {
                count++;
            }
        }

        in.close();
        return count;
    }

    /** Single method that returns all the lines of given number of char
    *   With this single method, no need to write Store3Words, Store4Words
    *   and Store7Words
    */
    public static String[] store(String fName, int size, int nChar) throws IOException {

        String[] words = new String[size];
        String temp = "";
        Scanner in = new Scanner(new File(fName));
        int i = 0;

        while (in.hasNextLine()) {
            temp = in.nextLine();
            if (temp.length() == nChar) {
                words[i] = temp;
                i++;
            }
        }

        in.close();
        return words;
    }

    public static String[] Char2Dig(String[] arr)  {        // ||

        String temp = "";
        String q = "";
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            str = "";
            for (int j = 0; j < temp.length(); j++) {
                for (int m = 2; m < DIG_CHAR.length; m++) {
                    for (int k = 0; k < DIG_CHAR[m].length; k++) {
                        if (temp.charAt(j) == DIG_CHAR[m][k]) {
                            q = q + DIG_CHAR[m];
                            str = str + q;
                            break;
                        }
                    }
                    if (q == "") {
                        continue;
                    }

                    break;
                }
                q = "";
            }

            arr[i] = str;
        }
        return arr;
    }

    public static void Print3(String[] WordsOf3, String[] arr, String s1) throws IOException {

        PrintWriter outfile = new PrintWriter(new FileWriter("result.txt"));
        Scanner in = new Scanner(new File(s1));
        String temp = "";

        while (in.hasNextLine()) {
            temp = in.nextLine().substring(4, 7);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == temp) {
                    outfile.println(temp + ": " + WordsOf3[i]);
                }
            }
        }


        outfile.close();
    }

    public static void Print4(String[] WordsOf4, String[] arr, String s1) throws IOException {

        PrintWriter outfile = new PrintWriter(new FileWriter("result.txt"));
        Scanner in = new Scanner(new File(s1));
        String temp = "";

        while (in.hasNextLine()) {
            temp = in.nextLine().substring(7, 11);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == temp) {
                    outfile.println(temp + ": " + WordsOf4[i]);
                }
            }
        }

        outfile.close();
    }

    public static void Print7(String[] WordsOf7, String[] arr, String s1) throws IOException {

        PrintWriter outfile = new PrintWriter(new FileWriter("result.txt"));
        Scanner in = new Scanner(new File(s1));
        String temp = "";

        while (in.hasNextLine()) {
            temp = in.nextLine().substring(4);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == temp) {
                    outfile.println(temp + ": " + WordsOf7[i]);
                }
            }
        }

        outfile.close();
    }

}