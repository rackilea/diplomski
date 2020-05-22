// Master list
List<String> master = new ArrayList<>(Arrays.asList("dog", "cat", "fish", "bunny", "hamster"));

// list to sort with respect to master      
List<String> listToSort = new ArrayList<>(Arrays.asList("bunny", "dog", "fish"));

// copy of master   
List<String> masterCopy = new ArrayList<>(master);

// keep only the items in masterCopy that are in the listToSort
masterCopy.retainAll(listToSort);

System.out.println(masterCopy);