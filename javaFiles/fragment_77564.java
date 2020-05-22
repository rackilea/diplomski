public static void main(String [] args) {
    List <Integer> a = new LinkedList<Integer>();
    qqq("Hello", a); // (21) error
}

static <T> void qqq(T t1, List <T> t2) {}