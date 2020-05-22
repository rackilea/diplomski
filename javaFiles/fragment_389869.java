import java.util.ArrayList;
import java.util.List;

public class NotSoMagical<T> {

    public List<T> arrayList;

    protected int length() {
        return arrayList.size();
    }

    NotSoMagical() {
        arrayList = new ArrayList<T>(10);
    }

    protected void set(T value, int index) {
        arrayList.set(index, value);
    }

    public static void main(String[] args) {
        NotSoMagical<Integer> notMagicalAtAll = new NotSoMagical<Integer>();
        System.out.println(notMagicalAtAll.length());
        System.out.println("MAGIC INCOMING");
        System.out.println(notMagicalAtAll.arrayList.size());
    }

}