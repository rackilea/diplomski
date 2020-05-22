public class MyClass {
    private String  group;
    private String  title;

    public MyClass(String g, String t) {
        group=g;
        title=t;
    }

    static Comparator<MyClass>  TITLE_COMPARATOR    = 
            new Comparator<MyClass>() {
                    @Override
                    public int compare(MyClass c1, MyClass c2) {
                            return c1.title.compareTo(c2.title);
                    }
            };
    static Comparator<MyClass>  GROUP_COMPARATOR    = new Comparator<MyClass>() {
                    @Override
                    public int compare(MyClass c1, MyClass c2) {
                            return c1.group.compareTo(c2.group);
                    }
            };

    public static List<MyClass> sublist(List<MyClass> list, String group) {
            ArrayList<MyClass> ret = new ArrayList<MyClass>();
            for (MyClass mc : list)
                if (mc.group.equals(group))
                    ret.add(mc);
            return ret;
        }

public static void main(String[] argv) {
    ArrayList<MyClass> sorted = new ArrayList<MyClass>();

    ArrayList<MyClass> list = new ArrayList<MyClass>();
    list.add(new MyClass("A", "5"));
    list.add(new MyClass("B", "9"));
    list.add(new MyClass("B", "1"));
    Collections.sort(list, TITLE_COMPARATOR);
    Hashtable<String, Boolean> visited = new Hashtable<String, Boolean>();
    for (MyClass mc : list) {
        if (visited.get(mc.group) == null) {
            List<MyClass> sublist = sublist(list, mc.group);
            Collections.sort(sublist, GROUP_COMPARATOR);
            sorted.addAll(sublist);
            visited.put(mc.group, Boolean.TRUE);
        }
    }

    for (MyClass mc : sorted)
        System.out.println(mc.group + " " + mc.title);
}