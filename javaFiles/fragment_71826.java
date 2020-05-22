exercises = removeFromArray(exercises, newString);
myAdapter.notifyDataSetChanged();

String[] removeFromArray(String[] arr, String removeMe) {
  ArrayList<String> newArray = new ArrayList<String>(arr);
  for (String item: newArray) {
    if (item.equals(removeMe) {
      newArray.remove(item);
    }
  }
  return newArray.toArray();
}