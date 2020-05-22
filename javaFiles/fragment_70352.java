public final class MyList {

    private static final List<String> list = new ArrayList<String>();

    private MyList() {
    }

    public static void add(String thing) {
        list.add(thing);
    }
}