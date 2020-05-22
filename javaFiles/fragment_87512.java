import java.util.Arrays;
import java.util.Collections;
import java.util.List;

enum Fruit { APPLE, PEAR, PEACH, PLUM, BANANA }

public class Hack {

    static List<Fruit> getFruitInOrder(Fruit local) {
        List<Fruit> list = Arrays.asList(Fruit.values());
        Collections.swap(list, 0, local.ordinal());
        Collections.shuffle(list.subList(1, list.size()));
        return list;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getFruitInOrder(Fruit.PLUM));
        }
    }
}