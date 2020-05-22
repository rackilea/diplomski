int partitionSize = 1000;
List<List<Integer>> partitions = new LinkedList<List<Integer>>();
for (int i = 0; i < originalList.size(); i += partitionSize) {
    partitions.add(originalList.subList(i,
            Math.min(i + partitionSize, originalList.size())));
}