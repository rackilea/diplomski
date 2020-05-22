import java.lang.reflect.Array;
import java.util.Arrays;

public class MySpecialArray<T> {

T[] buf;

int size;

Class<T> type;

public MySpecialArray(Class<T> type, int initialBufSize) {
    this.size = 0;
    this.type = type;

    buf = (T[]) Array.newInstance(type, initialBufSize);
}

    /**
 * Like arraylist add, it will basically add freely until it reaches the max length of the buffer.
 * Then it has to expand the buffer. It uses buf.length * 2 + 1 to account for when an initialBufSize of 0 is
 * supplied.
 * @param elem
 */
public void add(T elem) {
    if (this.size == this.buf.length) {
        int newSize = this.buf.length * 2 + 1;
        buf = Arrays.copyOf(buf, newSize);
    }
    this.buf[this.size] = elem;
    this.size += 1;
}

public void add(T...elements) {
    for(T elem : elements) {
        this.add(elem);
    }
}

/**
 * Remove all occurrences of an element. Also reduce the max buf_size of the array if my utilized size is less than a fourth of my max buf size.
 * @param removeMe element to remove all occurrences of
 * @return
 */
public void remove(T removeMe) {
    boolean found = false;
    for(int i = 0; i < this.size; i++) {
        if (buf[i].equals(removeMe)) {
            System.arraycopy(buf, i+1, buf, i, this.size - i);
            this.size -= 1;
            if (this.size < this.buf.length / 4) {
                this.buf = Arrays.copyOf(buf, this.buf.length / 2);
            }
        }
    }
}

/**
 * Remove the last element
 * @return
 */
public T remove() {
    if (this.size == 0) {
        throw new RuntimeException("Cannot remove from empty buffer");
    }
    T removed = this.buf[this.size -1];
    this.size -= 1;
    if (this.size <= this.buf.length / 4) {
        int newSize = this.buf.length / 2;
        this.buf = Arrays.copyOf(this.buf, newSize);
    }

    return removed;
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < this.size; i++) {
        sb.append(this.buf[i].toString()).append(",");
    }
    return sb.toString();
}

public static void main(String...args) {
    MySpecialArray<Integer> arr = new MySpecialArray(Integer.class, 50);
    arr.add(10, 2, 4, 3, 5, 11, 9, 3, 8, 16);

    System.out.println("===Pre removed===");
    System.out.println(arr.buf.length);
    System.out.println(arr.size);
    System.out.println(arr);
    arr.remove(3);

    System.out.println("===After removing 3===");
    System.out.println(arr.buf.length);
    System.out.println(arr.size);
    System.out.println(arr);
 }
}