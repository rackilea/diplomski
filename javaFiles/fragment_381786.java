import java.util.ArrayList;
import java.util.Collections;

public class ArraySort {

public static void main(String[] args) {
    ArrayList<Entity> arrayList = new ArrayList<Entity>();

    Entity entity1 = new Entity();
    entity1.setCount(2);
    entity1.setName("D");

    Entity entity2 = new Entity();
    entity2.setCount(10);
    entity2.setName("A");

    Entity entity3 = new Entity();
    entity3.setCount(5);
    entity3.setName("C");

    arrayList.add(entity1);
    arrayList.add(entity2);
    arrayList.add(entity3);

    System.out.println("Entity Count Sorting:");
    Collections.sort(arrayList, Entity.ArraylistComparator);

    for (Entity ent : arrayList) {
        System.out.println(ent);
    }
}

}