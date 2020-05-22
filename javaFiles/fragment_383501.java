package javaapplication1;

import java.util.TreeSet;

public class MyObj implements Comparable<MyObj> {

    public long sort_1;
    public long id;

    public MyObj(long sort, long id) {
        this.sort_1 = sort;
        this.id = id;
    }

    @Override
    public int compareTo(MyObj other) {
        return (this.equals(other))? 0 : Long.compare(sort_1, other.sort_1);
    }

    @Override
    public boolean equals(Object obj) {
        MyObj other = (MyObj) obj;
        return this.id == other.id && this.sort_1 == other.sort_1;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }


    public String toString() {
        return id + ":" + sort_1;
    }

    public static void main(String[] args) {
        TreeSet<MyObj> lst = new TreeSet<MyObj>();

        MyObj o1 = new MyObj(99L, 1L);
        MyObj o2 = new MyObj(11L, 9L);
        MyObj o3 = new MyObj(1234L, 1L);       
        MyObj o4 = new MyObj(1234L, 1L);   

        System.out.println( "Adding o1: " + lst.add(o1));
        System.out.println( "Adding o2: " + lst.add(o2));
        System.out.println( "Adding o3: " + lst.add(o3));
        System.out.println( "Adding o4: " + lst.add(o4));        

        System.out.println(lst);

        System.out.println("o1.compareTo(o3) : " + o1.compareTo(o3));
        System.out.println("o1.equals(o3) : " + o1.equals(o3));

        //remove myObje with id 1
        boolean remove = lst.remove(o3);

        System.out.println(lst);
    }

}