import java.util.Comparator;
    import java.util.Set;
    import java.util.TreeSet;

public class ComparatorExample {
private static class SbufferComparator implements Comparator<StringBuffer> {

        @Override
        public int compare(StringBuffer s1, StringBuffer s2) {
            return s1.toString().compareTo(s2.toString());

        }

}


    public static void main(String[] args) {
            StringBuffer one = new StringBuffer("one");
            StringBuffer  two = new StringBuffer("two");
            StringBuffer three = new StringBuffer("three");
            Set<StringBuffer> sb=new TreeSet<StringBuffer>(new SbufferComparator());
            sb.add(one);
            sb.add(two);
            sb.add(three);
            System.out.println("set before change: "+ sb);
            one.append("onemore");
            System.out.println("set After change: "+ sb);
        }
    }