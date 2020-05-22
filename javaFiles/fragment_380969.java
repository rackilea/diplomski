$> cat Some.java
import scala.Enumeration;

public class Some {
    public static void main(String args[]) {
        System.out.println("Hello!");
        System.out.println(MonthSelection.CustomMonth());
    }
}

$> javac -cp $SCALA_HOME/lib/scala-library.jar:bin/ -d bin Some.java
$> ls bin
MonthSelection$.class  MonthSelection.class  Some.class
$> java -cp $SCALA_HOME/lib/scala-library.jar:bin Some              
Hello!
CustomMonth