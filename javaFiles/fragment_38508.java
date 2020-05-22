private static ArrayList<String> list = new ArrayList<String>();
public static void main(String[] args) {
    list.add("foo");
    list.add("bar");
    if (!list.isEmpty() && !list.contains(null))
        System.out.println("ok");
    list.add(null);
    if (!list.isEmpty() && !list.contains(null))
        System.out.println("not ok");
}