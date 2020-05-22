for (int i = 0; i < sortedEntries.size() - 1; i++)
{
    Entry<Subnet, Set<String>> subnet = sortedEntries.get(i);
    Entry<Subnet, Set<String>> potentialSupernet = sortedEntries.get(i + 1);

    if (subnet.getKey().isPrefix(potentialSupernet.getKey()))
    {
        potentialSupernet.getValue().addAll(subnet.getValue());
        sortedEntries.remove(i);
        i--;
    }
}