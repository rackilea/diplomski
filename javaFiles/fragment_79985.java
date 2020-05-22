package so4483619;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AddDel {

  private static <K, V> HashMap<K, V> newLinkedHashMap() {
    return new LinkedHashMap<K, V>();
  }

  private static <K, V> HashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> other) {
    return new LinkedHashMap<K, V>(other);
  }

  private static void computeDeleteAndAdd(List<? extends Item> before, List<? extends Item> after) {
    Map<Long, Item> beforeById = newLinkedHashMap();
    for (Item item : before) {
      beforeById.put(item.getId(), item);
    }

    Map<Long, Item> afterById = newLinkedHashMap();
    for (Item item : after) {
      afterById.put(item.getId(), item);
    }

    Map<Long, Item> onlyBefore = newLinkedHashMap(beforeById);
    onlyBefore.keySet().removeAll(afterById.keySet());

    Map<Long, Item> onlyAfter = newLinkedHashMap(afterById);
    onlyAfter.keySet().removeAll(beforeById.keySet());

    for (Map.Entry<Long, Item> entry : onlyBefore.entrySet()) {
      System.out.println("delete:" + entry.getKey());
    }
    for (Map.Entry<Long, Item> entry : onlyAfter.entrySet()) {
      System.out.println("add:" + entry.getKey());
    }
  }

  public static void main(String[] args) {
    List<Item> beforeList = new ArrayList<Item>();
    List<ItemEx> afterList = new ArrayList<ItemEx>();

    beforeList.add(new Item(1L));
    beforeList.add(new Item(2L)); // delete
    beforeList.add(new Item(3L));

    afterList.add(new ItemEx(1L));
    afterList.add(new ItemEx(3L));
    afterList.add(new ItemEx(4L));

    computeDeleteAndAdd(beforeList, afterList);
  }
}