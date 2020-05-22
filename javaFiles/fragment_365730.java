public static class Nodez <E extends Comparable<E>> implements Comparable<Nodez<E>>{
        public String x;
        public E node;

        public String get(){
            return x;
        }

        @Override
        public int compareTo(Nodez<E> node) {
            return node.x.compareTo(x);
        }
    }

public static void main(String[] args) throws IOException
    {        

        Function<String, PrintStream> printUpperCase = x -> System.out.printf("%S", x);

        TreeSet<Nodez<String>> bstTest = new TreeSet<>();

        Nodez<String> e1 = new Nodez<>();
        e1.x = "fresh";


        bstTest.add(e1);

        System.out.println(bstTest.contains(e1));

    }