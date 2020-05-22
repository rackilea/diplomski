public class Comma {
    char[] str = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    char[] buf = new char[20];
    int size = str.length;
    int c = 1; 

public void insert() { for (int i = 0; i < size; i++) { if (c % 4 == 0) { buf[c - 1] = ','; i--; } else { buf[c - 1] = str[i]; } c++; } System.out.println("Final String"); for (int i = 0; i < buf.length; i++) { System.out.print(buf[i]); } } public static void main(final String args[]) { Comma c = new Comma(); c.insert(); }