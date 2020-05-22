public static class MyObject implements Comparable<MyObject> {

    public int distance;
    public String name;
    public float value;


    // Replace this with whichever field is needed
    @Override
    public int compareTo(MyObject o) {
        // If it's the String
        return this.name.compareTo(o.name);
        // If it's one of the values
        return this.distance - o.distance;
    }
}