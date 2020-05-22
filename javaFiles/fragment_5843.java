import java.util.LinkedList;

public class MyList {
    private LinkedList<Integer> list;

    public MyList(LinkedList<Integer> list) {
        this.list = list;
    }

    public LinkedList<Integer> reverse() {
        //Create a reversed list

        return rList;
    }

    public LinkedList<Integer> odd() {
        //Create a list of the odd elements

        return oddList
    }

    public LinkedList<Integer> even() {
        //Create a list of the even elements

        return evenList;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(0);
        list.add(2);
        list.add(4);

        MyList ml = new MyList(list);
        System.out.println("MyList: " + ml);
        LinkedList<Integer> tsil = ml.reverse();
        System.out.println("Reversed: " + tsil);
        LinkedList<Integer> ls = ml.odd();
        System.out.println("Odd: " + ls);
        LinkedList<Integer> it = ml.even();
        System.out.println("Even: " + it);
    }
}