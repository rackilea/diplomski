import java.util.*;
class AwesomeVector<E> extends Vector<E> {

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size(); i++) {
           if(i != 0) sb.append(","); 
           sb.append(get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        AwesomeVector<String> av = new AwesomeVector<String>();
        av.add("This");
        av.add("is");
        av.add("a test");
        System.out.println(av.toString());
    }

}


C:\Documents and Settings\glowcoder\My Documents>javac AwesomeVector.java

C:\Documents and Settings\glowcoder\My Documents>java AwesomeVector
[This,is,a test]