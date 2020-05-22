List<Integer> numbers = new ArrayList<Integer>(SIZE);
for (int i = 0;i<SIZE; i++) {
    addUniqueRandomNumber(numbers, SIZE*2);
}

for (int i =0;i<numbers.size; i++) {
  Node newNode = new Node(numbers.get(i));        
  nodeArray[i] = newNode;
}