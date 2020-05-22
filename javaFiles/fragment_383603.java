List<Integer> lst = new ArrayList<>();
lst.add(1);
lst.add(2);
lst.add(4);
lst.add(8);
lst.add(15);

// Collections.sort(lst); // assuming list is sorted

// your key 
int key = 7;

// binary search to look for position where it would be inserted.
// if negative number does not exist so next number would be at ' -pos - 1' 
// if positive number exists so next number would be at 'pos + 1' 
int pos = Collections.binarySearch(lst, key);
pos = pos < 0 ? -pos - 1 : pos + 1;

// check for out of bounds as search for last number would give index out of bounds
pos = pos == lst.size() ? pos - 1 : pos;

// your next number
System.out.println(lst.get(pos));