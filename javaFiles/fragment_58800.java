List<MyObject> objects = new ArrayList<MyObject>();
objects.add(new MyObject("apple", "low"));
objects.add(new MyObject("bacon", "medium"));
objects.add(new MyObject("cheese", "low"));
objects.add(new MyObject("doughnut", "high"));
objects.add(new MyObject("eggs", null));
objects.add(new MyObject("fudge", null));

final List<String> priority = new ArrayList<String>();
priority.add("high");
priority.add("medium");
priority.add("low");

Comparator<MyObject> comparator = new Comparator<MyObject>() {
    public int compare(MyObject o1, MyObject o2) {
        int p1 = priority.indexOf(o1.getPriority());
        int p2 = priority.indexOf(o2.getPriority());
        if (p1 == -1 && p2 != -1) {
            return 1;
        }
        if (p1 != -1 && p2 == -1) {
            return -1;
        }
        if (p1 != p2) {
            return p1 - p2;
        }
        return o1.getName().compareTo(o2.getName());
    }
};

Collections.sort(objects, comparator);

for(MyObject obj : objects) {
    System.out.printf("%-10s %10s%n", obj.getName(), obj.getPriority());
}