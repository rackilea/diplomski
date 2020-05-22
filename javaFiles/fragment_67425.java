l.add(new MyLink("Greg", "West"));
    l.add(new MyLink("Joe", "Rogers"));
    l.add(new MyLink("Bill", "Thomas"));

    Collections.sort(l);
    for(MyLink link:l){
        link.print();
    }
}

public static class MyLink implements Comparable<MyLink>{
    public MyLink next;
    public String first;
    public String last;

    public MyLink(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public void print() {
        System.out.printf("%s %s\n", first, last);
    }

    @Override
    public int compareTo(MyLink o) {
        int result = this.last.compareTo(o.last);
        if(result==0){
            result = this.first.compareTo(o.first);
        }
        return result;
    }
}