List<List<Integer>> store = new ArrayList<>(); // Create storage for versions

List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
store.add(new ArrayList<>(list)); // Add list's copy to store.

list.add(5); // Edit it as you want.
store.add(new ArrayList<>(list)); // Add list's copy to store.

System.out.println(store); // Print all versions