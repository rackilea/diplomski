import java.io.*;

class Wx {
    public static void main(String args[]) throws IOException {
        String str="Oh ho ho ho oh ho ho ho oh ho ho ho ohho ishq tera tadpaaweee";
        FileWriter f=new FileWriter("text");
        for(int i=0;i<str.length();i++) {
            f.write(str.charAt(i));
        }
        f.close();
    }
}