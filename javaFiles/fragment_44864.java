ArrayList<String> arrList1 = new ArrayList<String>(); // for the 1st num in each pair of 3
ArrayList<String> arrList2 = new ArrayList<String>(); // for the 2nd num in each pair of 3
ArrayList<String> arrList2 = new ArrayList<String>(); // for the 3rd num in each pair of 3


// then loop this part below for however many elements are in the original ArrayList "list"
String str = list.get(0); // assuming index 0 was "3 9 12"
String[] arr = str.split(" ");
arrList1.add(arr[0]);
arrList2.add(arr[1]);
arrList3.add(arr[2]);