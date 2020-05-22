aioobe@e6510:~/tmp$ cat Test.java 


public class Test {
    public static void main(String[] args) {
        java.util.List<Integer> myInts = new java.util.ArrayList<Integer>();
    }
}
aioobe@e6510:~/tmp$ javac Test.java
aioobe@e6510:~/tmp$ md5sum Test.class 
523036e294b17377b4078ea1cb8e7940  Test.class