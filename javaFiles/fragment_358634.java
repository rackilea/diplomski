Map<int[], String> map = new HashMap<>();

int[] arr1 = { 1, 2 };
map.put(arr1, "Hello");

int[] arr2 = { 1, 2 };
System.out.println(map.get(arr2));  // null, since arr1.equals(arr2) == false