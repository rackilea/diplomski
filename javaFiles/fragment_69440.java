static class QuickSort {

  public static ArrayList<Integer> sort(ArrayList<Integer> array) {

    if (array.size() <= 1) {
      return array;
    }

    int middle = (int) Math.ceil((double) array.size() / 2);
    int pivot = array.get(middle);

    ArrayList<Integer> less = new ArrayList<>();
    ArrayList<Integer> greater = new ArrayList<>();

    for (int i = 0; i < array.size(); i++) {
      if (array.get(i) <= pivot) {
        if (i == middle) {
          continue;
        }
        less.add(array.get(i));
      } else {
        greater.add(array.get(i));
      }
    }

    return concatenate(sort(less), pivot, sort(greater), array);
  }

  private static ArrayList<Integer> concatenate(ArrayList<Integer> less, int pivot, ArrayList<Integer> greater, ArrayList<Integer> list) {

    list.clear();

    for (int i = 0; i < less.size(); i++) {
      list.add(less.get(i));
    }

    list.add(pivot);

    for (int i = 0; i < greater.size(); i++) {
      list.add(greater.get(i));
    }

    return list;
  }
}