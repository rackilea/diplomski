private class MyObject implements Comparable<MyObject> {

    private Time time;
    private String name;

    public MyObject(String name, Time time) {
        this.time = time;
        this.name = name;
    }

    @Override
    public int compareTo(MyObject o) {
        return (this.getTime().compareTo(o.getTime()));
    }

    public Time getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name + " : " + time;
    }

}