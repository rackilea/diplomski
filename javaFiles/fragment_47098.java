$ javac Break.java
$ javac -source 1.4 -target 1.4 Break.java
Break.java:4: for-each loops are not supported in -source 1.4
(try -source 1.5 to enable for-each loops)
    for (int x:numbers){
              ^
1 error