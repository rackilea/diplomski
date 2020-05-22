public class FooDemo {
    public static void main(String[] args) {
        System.out.println("output: " + Foo.bar(""));
    }
}

$ java -version
java version "1.6.0"
Java(TM) SE Runtime Environment (build 1.6.0-b105)
$ javac FooDemo.java
$java FooDemo 
output: true