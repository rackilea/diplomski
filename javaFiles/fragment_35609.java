make:  gramatica main

gramatica: laboratorios/lab02/Lab02.g
    java org.antlr.v4.Tool laboratorios/lab02/Lab02.g

main: laboratorios/lab02/Lab02.java laboratorios/lab02/Main.java
    javac laboratorios/lab02/Lab02.java laboratorios/lab02/Main.java

run: laboratorios/lab02/Main.class
    java -cp ${CLASSPATH}:Lab02.class laboratorios/lab02/Main test.txt

clean:
    rm -rf laboratorios/lab02/*.tokens
    rm -rf laboratorios/lab02/*.class
    rm -rf laboratorios/lab02/Lab02.java
    rm -rf laboratorios/lab02/*~