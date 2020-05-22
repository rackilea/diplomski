public class TreeSpy {

    private static Object get(Object o, String fieldName) {
        try {
            Field declaredField = o.getClass().getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            return declaredField.get(o);
        } catch (Exception e) {
            System.err.println("Could not gain access to field "
                    + fieldName + " of " + o.getClass());
            e.printStackTrace();
            return null;
        }
    }

    private static int diveInto(Object n, int depth, String indent) {
        if (n == null) return depth-1; // we are empty, and should not be counted
        Object left = get(n, "left");
        Object right = get(n, "right");
        String key = (String)get(n, "key");

        int childrenCount = 0 + (left!=null?1:0) + (right!=null?1:0);
        System.out.println(indent + key +
                ": depth=" + depth + ", chidren=" + childrenCount);
        return Math.max(
                diveInto(left,  depth+1, indent+"  "),
                diveInto(right, depth+1, indent+"  "));
    }

    public static void showDepthAndChildren(TreeSet<String> set) {
        TreeMap<String, Object> m = (TreeMap<String, Object>)get(set, "m");
        Object root = get(m, "root");
        int maxDepth = diveInto(root, 1, "");
        System.out.println("Height = Max Depth = " + maxDepth);
    }

    public static void main(String ... args) {
        TreeSet<String> test = new TreeSet<>();
        for (String s : "once upon a time in a galaxy far far away".split(" ")) {
            test.add(s);
        }
        showDepthAndChildren(test);
    }
}