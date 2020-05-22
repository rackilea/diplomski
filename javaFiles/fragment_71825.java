exercises = addToArray(exercises, newString);
myAdapter.notifyDataSetChanged();

String[] addToArray(String[] arr, String newString) {
  ArrayList<String> newArray = new ArrayList<String>(arr);
  arr.add(newString);
  return newArray.toArray();
}