import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class RandomHashSet<E> extends HashSet<E> {
    private Random mRand = new Random();

    public E randomElement() {
        if (size() == 0) {
            return null;
        }
        int index = mRand.nextInt(size());
        Iterator<E> iter = iterator();
        for (int i = 0; i < index; i++) {
            iter.next();
        }
        return iter.next();
    }
}