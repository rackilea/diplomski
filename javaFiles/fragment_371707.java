# cat X.java
public class X { public static void main(String[] args) {
                System.out.println( (new java.util.Date()).getTime());
                System.out.println( System.currentTimeMillis());
        } }

# javac X.java ; java X ; perl -e 'print time()*1000'
1305133124654
1305133124654
1305133124000