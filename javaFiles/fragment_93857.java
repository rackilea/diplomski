public interface Things<T> extends Iterable<T> {
    public int size();
    public boolean add(T x);
    public T remove(T x);
    public T find(T x);
    public void clear();
}
//Implementing thing using bag
public class Bag<T> implements Things<T> {
    private ArrayList<T> list = new ArrayList<T>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean add(T x) {
        list.add(x);
    }

    @Override
    //It's weird why the remove method returns T
    //Sine you already pass x of type T as parameter
    public T remove(T x) {
        list.remove(x);
        return x;
    }

    @Override
    public T find(T x) {
        //Since you already know x, what is find() searching for?
        return null;
    }

}


public class ThingsDemo {


    public static void main(String args[])

    {
        Bag<String> bag = new Bag<>();
        bag.add("cat");  
        bag.remove("cat");
    }
}