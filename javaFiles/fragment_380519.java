[root@localhost hellworld]# cat HelloWorld.java 

public class HelloWorld {

  public static void main(String[] args) throws Exception {
      System.out.println("Hello World!");
}}


[root@localhost hellworld]# javac HelloWorld.java 
[root@localhost hellworld]# jar cvf helloworld.jar HelloWorld.class 

[root@localhost hellworld]# ~/Downloads/hadoop-2.1.0-beta/bin/hadoop jar helloworld.jar HelloWorld
Hello World!