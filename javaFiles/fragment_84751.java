public class MyObject implements Comparable<MyObject> {
    // ... your existing code here ...
    @Override
    public int compareTo(MyObject other) {
        // do smart things here
    }
}

// Elsewhere:
List<MyObject> list = ...;
Collections.sort(list);