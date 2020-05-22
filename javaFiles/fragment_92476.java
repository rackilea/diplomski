List<String> data = Arrays.asList("a", "b", "c");

Node previousNode = null;
for (String datum : data)
{
    previousNode = new Node(datum, previousNode);
}
//previousNode now contains a reference to the last node (C)