import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyIterator implements Iterator<Integer> {
    @Override
    public boolean hasNext() {
        return 0 <= i && i < x.length;
    }

    @Override
    public Integer next() {
        return x[i++];
    }

    private Integer i = 0;
    private Integer[] x = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
}

class MyBatchIterator {
    MyBatchIterator(MyIterator myIterator, int n) {
        this.myIterator = myIterator;
        this.n = n;
    }

    public boolean hasNext() {
        return myIterator.hasNext();
    }

    public List<Integer> next() {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            if (myIterator.hasNext()) list.add(myIterator.next());
        return list;
    }

    final MyIterator myIterator;
    final int n;
}

class Main {
    public static void main(String[] args) {
        MyBatchIterator myBatchIterator = new MyBatchIterator(new MyIterator(), 3);
        while (myBatchIterator.hasNext())
            System.out.println(myBatchIterator.next());
    }
}