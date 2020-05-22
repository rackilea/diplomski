aioobe@r60:~/tmp$ cat Test.java 
public class Test {
    public static void main(String[] args) {
        System.out.println("\"" + System.getProperty("line.separator") + "\"");
    }
}
aioobe@r60:~/tmp$ javac Test.java && java -Dline.separator=$'\n' Test
"
"
aioobe@r60:~/tmp$