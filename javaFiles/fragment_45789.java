package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortResult {

public static void main(String[] args) {
    int[] sortOrder = { 5, 2, 8, 4, 14, 1, 6, 9, 3, 7 };
    List<Thing> things = new ArrayList<Thing>();
    for (int i = 1; i < 10; i++) {
        Thing thing = new Thing();
        thing.setId(i);
        things.add(thing);
    }
    Map<Integer, Thing> thingMap = new HashMap<Integer, Thing>();
    for (Thing thing : things) {
        thingMap.put(thing.getId(), thing);
    }
    List<Thing> sortedThings = new ArrayList<Thing>();
    for (int id : sortOrder) {
        if (thingMap.get(id) != null) {
            sortedThings.add(thingMap.get(id));
        }
    }
    System.out.println("expected order: "+Arrays.toString(sortOrder)
                 +"\nActual order: ");
    for(Thing thing:sortedThings) {
        System.out.println(thing);
    }
}
}

class Thing {
int id;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

@Override
public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Thing [id=").append(id).append("]");
    return builder.toString();
}
}