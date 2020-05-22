exercises = filterArray(exercises, filter);  
myAdapter.notifyDataSetChanged();

String[] filterArray(String[] arr, String filter) {
  ArrayList<String> newArray = new ArrayList<String>();
  for (int i=0;i<arr.length()<i++) {
    if (arr[i].contains(filter) {
      newArray.add(arr[i]);
    }
  }
  return newArray.toArray();
}