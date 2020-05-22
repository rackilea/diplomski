import java.util.AbstractQueue;
import java.util.Iterator;

public class MyQueue<T> extends AbstractQueue<T> {

    private T[] arr;
    private int headPos;
    private int tailPos;
    private int size = 0;

    @Override
    public boolean offer(T e) {
        if (size < arr.length)
            size++;
        else if (headPos == tailPos)
            headPos = nextPos(headPos);
        arr[tailPos] = e;
        tailPos = nextPos(tailPos);
        return true;
    }

    private int nextPos(int pos) {
        return (pos + 1) % arr.length;
    }

    @Override
    public T peek() {
        if (size == 0)
            return null;
        return arr[headPos];
    }

    @Override
    public T poll() {
        if (size == 0)
            return null;
        size--;
        T res = arr[headPos];
        headPos = nextPos(headPos);
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    public static void main(String[] args) {
        MyQueue<Integer> realQueue = new MyQueue<Integer>(Integer[].class, 10);
        System.out.println(realQueue.offer(20));
    }
    public MyQueue(Class<T[]> clazz, int length) {
        arr = clazz.cast(Array.newInstance(clazz.getComponentType(), length));
    }

}