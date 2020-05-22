int partitionSize = 2;
List<List<String>> partitions = new LinkedList<List<String>>();
for (int i = 0; i < messages.size(); i += partitionSize) {
    partitions.add(messages.subList(i,
            i + Math.min(partitionSize, messages.size() - i)));
}